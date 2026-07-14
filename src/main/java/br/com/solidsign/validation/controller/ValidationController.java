package br.com.solidsign.validation.controller;

import br.com.solidsign.validation.model.ValidationReportsResponseDTO;
import br.com.solidsign.validation.service.ValidationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Exposes two validation endpoints for CAdES/CMS signatures:
 *   POST /api/cms/validate/batch — reads .p7s/.p7b files from server-side input directory
 *   POST /api/cms/validate/form  — receives CMS files via multipart form upload
 *
 * For DETACHED CAdES, attach original (unsigned) files using the field "originalFile".
 */
@RestController
@RequestMapping("/api/cms/validate")
public class ValidationController {

    private final ValidationService service;

    public ValidationController(ValidationService service) {
        this.service = service;
    }

    /**
     * Validates all CMS files in the configured input directory.
     * Original files for DETACHED CAdES are loaded from {@code solidsign.batch.original-path} if set.
     *
     * Example:
     *   curl -X POST http://localhost:8095/api/cms/validate/batch
     */
    @PostMapping("/batch")
    public ResponseEntity<ValidationReportsResponseDTO> validateBatch() throws IOException {
        return ResponseEntity.ok(service.validateBatch());
    }

    /**
     * Validates CMS files sent as multipart form data.
     * {@code originalFile} is optional and required only for DETACHED CAdES signatures.
     *
     * Example (enveloping):
     *   curl -X POST http://localhost:8095/api/cms/validate/form \
     *        -F "document=@/path/to/signed.p7s"
     *
     * Example (detached):
     *   curl -X POST http://localhost:8095/api/cms/validate/form \
     *        -F "document=@/path/to/signature.p7s" \
     *        -F "originalFile=@/path/to/original.pdf"
     */
    @PostMapping("/form")
    public ResponseEntity<ValidationReportsResponseDTO> validateForm(
            @RequestPart("document") List<MultipartFile> cmsFiles,
            @RequestPart(value = "originalFile", required = false) List<MultipartFile> origFiles)
            throws IOException {
        return ResponseEntity.ok(service.validateForm(cmsFiles, origFiles));
    }
}
