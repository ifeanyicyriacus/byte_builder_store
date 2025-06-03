package org.estore.estore.integration;

import lombok.RequiredArgsConstructor;
import org.estore.estore.dto.response.walrus.WalrusUploadResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpMethod.PUT;

@Component
@RequiredArgsConstructor
public class WalrusCloudService implements CloudService {
    @Value("${walrus.epochs}")
    private       String       epochs;
    @Value("${walrus.upload.address}")
    private       String       walrusUploadAddress;
    @Value("${walrus.upload.url}")
    private       String       walrusURL;
    private final RestTemplate restTemplate;

    @Override
    public String upload(MultipartFile file) {
        return extractBlobIdFrom(restTemplate.exchange(walrusURL, PUT,
                buildUploadRequest(file), WalrusUploadResponse.class, createQueryParam()));
    }

    private HttpEntity<?> buildUploadRequest(MultipartFile file) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        Resource resource = file.getResource();
        return new HttpEntity<>(resource, headers);
    }

    private static String extractBlobIdFrom(ResponseEntity<WalrusUploadResponse> response) {
        WalrusUploadResponse walrusUploadResponse = response.getBody();
        boolean isFileAlreadyExists = walrusUploadResponse != null && walrusUploadResponse.getNewlyCreated() == null;
        if (isFileAlreadyExists) return walrusUploadResponse.getAlreadyCertified().getBlobId();
        assert walrusUploadResponse != null;
        return walrusUploadResponse.getNewlyCreated().getBlobObject().getBlobId();
    }

    private Map<String, ?> createQueryParam() {
        Map<String, Object> params = new HashMap<>();
        params.put("epochs", epochs);
        params.put("send_object_to", walrusUploadAddress);
        return params;
    }
}