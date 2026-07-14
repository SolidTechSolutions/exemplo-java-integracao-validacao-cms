package br.com.solidsign.validation.service;

import br.com.solidsign.validation.model.ValidationReportsResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class ValidationService {

    private static final Logger log = LoggerFactory.getLogger(ValidationService.class);

    private final RestTemplate restTemplate;

    @Value("${solidsign.api.base-url}")
    private String baseUrl;

    @Value("${solidsign.api.authorization}")
    private String authorization;

    @Value("${solidsign.batch.input-path}")
    private String batchInputPath;

    /**
     * Optional: directory containing original (unsigned) files for DETACHED CAdES validation.
     * When provided, each original file is matched by name to the corresponding CMS signature.
     */
    @Value("${solidsign.batch.original-path:}")
    private String batchOriginalPath;

    public ValidationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Validates CMS (.p7s / .p7b) files from the configured input directory.
     * If solidsign.batch.original-path is set, includes the matching originals for DETACHED signatures.
     */
    public ValidationReportsResponseDTO validateBatch() throws IOException {
        File dir = new File(batchInputPath);
        File[] cmsFiles = dir.listFiles((d, name) -> {
            String n = name.toLowerCase();
            return n.endsWith(".p7s") || n.endsWith(".p7b") || n.endsWith(".p7m");
        });
        if (cmsFiles == null || cmsFiles.length == 0) {
            throw new IllegalArgumentException("No CMS files (.p7s/.p7b/.p7m) found in: " + batchInputPath);
        }

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        for (File cms : cmsFiles) {
            body.add("document", new FileSystemResource(cms));
        }

        // Attach original files for DETACHED CAdES if the directory is configured
        if (batchOriginalPath != null && !batchOriginalPath.isBlank()) {
            File origDir = new File(batchOriginalPath);
            for (int i = 0; i < cmsFiles.length; i++) {
                String baseName = cmsFiles[i].getName().replaceAll("\\.[^.]+$", "");
                File[] origMatches = origDir.listFiles((d, name) -> name.startsWith(baseName));
                if (origMatches != null && origMatches.length > 0) {
                    body.add("originalFile[" + i + "]", new FileSystemResource(origMatches[0]));
                }
            }
        }

        log.info("Validating {} CMS file(s) from {}", cmsFiles.length, batchInputPath);
        return callApi(body);
    }

    /**
     * Validates CMS files received via multipart form upload.
     * @param cmsFiles  the CMS signature files (.p7s / .p7b)
     * @param origFiles optional original files for DETACHED signatures (same order as cmsFiles)
     */
    public ValidationReportsResponseDTO validateForm(
            List<MultipartFile> cmsFiles,
            List<MultipartFile> origFiles) throws IOException {

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        for (MultipartFile mf : cmsFiles) {
            Path tmp = Files.createTempFile("solidsign-cms-", ".p7s");
            mf.transferTo(tmp);
            tmp.toFile().deleteOnExit();
            String originalName = mf.getOriginalFilename();
            body.add("document", new FileSystemResource(tmp.toFile()) {
                @Override public String getFilename() { return originalName; }
            });
        }

        if (origFiles != null) {
            for (int i = 0; i < origFiles.size(); i++) {
                MultipartFile orig = origFiles.get(i);
                Path tmp = Files.createTempFile("solidsign-orig-", "");
                orig.transferTo(tmp);
                tmp.toFile().deleteOnExit();
                final int idx = i;
                String originalName = orig.getOriginalFilename();
                body.add("originalFile[" + idx + "]", new FileSystemResource(tmp.toFile()) {
                    @Override public String getFilename() { return originalName; }
                });
            }
        }

        log.info("Validating {} uploaded CMS file(s)", cmsFiles.size());
        return callApi(body);
    }

    private ValidationReportsResponseDTO callApi(MultiValueMap<String, Object> body) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        headers.set(HttpHeaders.AUTHORIZATION, authorization);

        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(body, headers);
        String url = baseUrl.replaceAll("/+$", "") + "/solidsign/dsig/validation/verify-cms";

        ResponseEntity<ValidationReportsResponseDTO> response =
            restTemplate.exchange(url, HttpMethod.POST, request, ValidationReportsResponseDTO.class);

        return response.getBody();
    }
}
