# 🇧🇷 SolidSign API - Exemplo de Validação de Assinatura CMS (CAdES)

Este projeto demonstra a integração com a **SolidSign API** para validar assinaturas digitais CAdES (CMS — `.p7s`, `.p7b`, `.p7m`), retornando um relatório de validação detalhado. Suporta dois modos: **batch** (lê arquivos de uma pasta local) e **form** (upload HTTP), além de assinaturas **DETACHED** (com o arquivo original separado).

## Estrutura do Projeto

* **Controller:** Expõe `/batch` e `/form`. No `/form`, aceita o campo opcional `originalFile` para validação DETACHED.
* **Service:** Orquestra `POST /solidsign/dsig/validation/verify-cms`, montando `document[i]` e, quando aplicável, `originalFile[i]` alinhado por índice.

## Configuração (application.properties)

| Atributo | Descrição | Exemplo / Valor |
| :--- | :--- | :--- |
| `server.port` | Porta local do servidor. | `8095` |
| `solidsign.api.base-url` | URL base da SolidSign API (sem o caminho). | `https://solidsign.com.br` |
| `solidsign.api.authorization` | Token JWT de autorização (Bearer). | `Bearer eyJhbGciOiJIUzI1...` |
| `solidsign.batch.input-path` | Pasta local com os arquivos CMS a validar (modo batch). | `C:/signed_cms` |
| `solidsign.batch.original-path` *(opcional)* | Pasta com os arquivos originais para validação **DETACHED** (mesmo nome-base do CMS). | `C:/original_files` |
| `solidsign.batch.output-path` | Pasta onde o relatório JSON de validação será salvo. | `C:/validation_results` |

## Endpoints

| Método | Rota | Descrição |
| :--- | :--- | :--- |
| `POST` | `/api/cms/validate/batch` | Valida os CMS da pasta de entrada; anexa originais de `original-path` se configurado. |
| `POST` | `/api/cms/validate/form` | Valida CMS enviados via `multipart` (campo `document`; `originalFile` opcional para DETACHED). |

## Stack
1. Java 17
2. Spring Boot 3.2.5
3. Maven 3.x+
4. RestTemplate (cliente HTTP) + Logback (logging)

## Como Executar

1. **Configurar:** Ajuste as propriedades em `src/main/resources/application.properties`.
2. **Compilar:** `mvn clean install`
3. **Iniciar:** `mvn spring-boot:run`
4. **Testar (batch):** `curl -X POST http://localhost:8095/api/cms/validate/batch`
5. **Testar (form, enveloping):** `curl -X POST http://localhost:8095/api/cms/validate/form -F "document=@/caminho/assinatura.p7s"`
6. **Testar (form, DETACHED):** `curl -X POST http://localhost:8095/api/cms/validate/form -F "document=@/caminho/assinatura.p7s" -F "originalFile=@/caminho/original.pdf"`

## Resposta

O relatório (`ValidationReportsResponseDTO`) contém `documentCount` e `documentValidations[]` com `globalIndication`, quantidade de assinaturas e detalhes de cada uma (tipo, padrão, perfil, integridade, validade do certificado, carimbos de tempo).

## Tratamento de Erros
O serviço repassa os erros **4xx/5xx** da SolidSign e registra o corpo JSON detalhado via Logback. Para CAdES DETACHED, certifique-se de que cada `originalFile` corresponde ao `document` de mesmo índice.

---

# 🇬🇧 SolidSign API - CMS Signature Validation Example (CAdES)

This project demonstrates the integration with the **SolidSign API** to validate CAdES digital signatures (CMS — `.p7s`, `.p7b`, `.p7m`), returning a detailed validation report. It supports two modes: **batch** (local folder) and **form** (HTTP upload), plus **DETACHED** signatures (with the original file separate).

## Project Structure

* **Controller:** Exposes `/batch` and `/form`. The `/form` endpoint accepts the optional `originalFile` field for DETACHED validation.
* **Service:** Orchestrates `POST /solidsign/dsig/validation/verify-cms`, building `document[i]` and, when applicable, `originalFile[i]` aligned by index.

## Configuration (application.properties)

| Attribute | Description | Example / Value |
| :--- | :--- | :--- |
| `server.port` | Local server port. | `8095` |
| `solidsign.api.base-url` | Base URL of the SolidSign API (without path). | `https://solidsign.com.br` |
| `solidsign.api.authorization` | Authorization JWT Token (Bearer). | `Bearer eyJhbGciOiJIUzI1...` |
| `solidsign.batch.input-path` | Local folder with CMS files to validate (batch mode). | `C:/signed_cms` |
| `solidsign.batch.original-path` *(optional)* | Folder with the original files for **DETACHED** validation (same base name as the CMS). | `C:/original_files` |
| `solidsign.batch.output-path` | Local folder where the JSON validation report will be saved. | `C:/validation_results` |

## Endpoints

| Method | Route | Description |
| :--- | :--- | :--- |
| `POST` | `/api/cms/validate/batch` | Validates CMS files in the input folder; attaches originals from `original-path` if configured. |
| `POST` | `/api/cms/validate/form` | Validates CMS sent via `multipart` (field `document`; optional `originalFile` for DETACHED). |

## Stack
1. Java 17
2. Spring Boot 3.2.5
3. Maven 3.x+
4. RestTemplate (HTTP client) + Logback (logging)

## How to Run

1. **Configure:** Set the properties in `src/main/resources/application.properties`.
2. **Build:** `mvn clean install`
3. **Start:** `mvn spring-boot:run`
4. **Test (batch):** `curl -X POST http://localhost:8095/api/cms/validate/batch`
5. **Test (form, enveloping):** `curl -X POST http://localhost:8095/api/cms/validate/form -F "document=@/path/signature.p7s"`
6. **Test (form, DETACHED):** `curl -X POST http://localhost:8095/api/cms/validate/form -F "document=@/path/signature.p7s" -F "originalFile=@/path/original.pdf"`

## Response

The report (`ValidationReportsResponseDTO`) contains `documentCount` and `documentValidations[]` with `globalIndication`, the signature count, and the details of each one (type, standard, profile, integrity, certificate validity, timestamps).

## Error Handling
The service forwards SolidSign **4xx/5xx** errors and logs the detailed JSON body via Logback. For DETACHED CAdES, ensure each `originalFile` matches the `document` at the same index.

---

# 🇪🇸 SolidSign API - Ejemplo de Validación de Firma CMS (CAdES)

Este proyecto demuestra la integración con la **SolidSign API** para validar firmas digitales CAdES (CMS — `.p7s`, `.p7b`, `.p7m`), devolviendo un informe de validación detallado. Admite dos modos: **batch** (carpeta local) y **form** (carga HTTP), además de firmas **DETACHED** (con el archivo original por separado).

## Estructura del Proyecto

* **Controller:** Expone `/batch` y `/form`. El endpoint `/form` acepta el campo opcional `originalFile` para validación DETACHED.
* **Service:** Orquesta `POST /solidsign/dsig/validation/verify-cms`, armando `document[i]` y, cuando aplica, `originalFile[i]` alineado por índice.

## Configuración (application.properties)

| Atributo | Descripción | Ejemplo / Valor |
| :--- | :--- | :--- |
| `server.port` | Puerto local del servidor. | `8095` |
| `solidsign.api.base-url` | URL base de la SolidSign API (sin la ruta). | `https://solidsign.com.br` |
| `solidsign.api.authorization` | Token JWT de autorización (Bearer). | `Bearer eyJhbGciOiJIUzI1...` |
| `solidsign.batch.input-path` | Carpeta local con los archivos CMS a validar (modo batch). | `C:/signed_cms` |
| `solidsign.batch.original-path` *(opcional)* | Carpeta con los archivos originales para validación **DETACHED** (mismo nombre base que el CMS). | `C:/original_files` |
| `solidsign.batch.output-path` | Carpeta donde se guardará el informe JSON de validación. | `C:/validation_results` |

## Endpoints

| Método | Ruta | Descripción |
| :--- | :--- | :--- |
| `POST` | `/api/cms/validate/batch` | Valida los CMS de la carpeta de entrada; adjunta originales de `original-path` si está configurado. |
| `POST` | `/api/cms/validate/form` | Valida CMS enviados vía `multipart` (campo `document`; `originalFile` opcional para DETACHED). |

## Stack
1. Java 17
2. Spring Boot 3.2.5
3. Maven 3.x+
4. RestTemplate (cliente HTTP) + Logback (registro)

## Cómo Ejecutar

1. **Configurar:** Ajuste las propiedades en `src/main/resources/application.properties`.
2. **Compilar:** `mvn clean install`
3. **Iniciar:** `mvn spring-boot:run`
4. **Probar (batch):** `curl -X POST http://localhost:8095/api/cms/validate/batch`
5. **Probar (form, enveloping):** `curl -X POST http://localhost:8095/api/cms/validate/form -F "document=@/ruta/firma.p7s"`
6. **Probar (form, DETACHED):** `curl -X POST http://localhost:8095/api/cms/validate/form -F "document=@/ruta/firma.p7s" -F "originalFile=@/ruta/original.pdf"`

## Respuesta

El informe (`ValidationReportsResponseDTO`) contiene `documentCount` y `documentValidations[]` con `globalIndication`, la cantidad de firmas y los detalles de cada una (tipo, estándar, perfil, integridad, validez del certificado, sellos de tiempo).

## Gestión de Errores
El servicio reenvía los errores **4xx/5xx** de SolidSign y registra el cuerpo JSON detallado vía Logback. Para CAdES DETACHED, asegúrese de que cada `originalFile` corresponde al `document` del mismo índice.
