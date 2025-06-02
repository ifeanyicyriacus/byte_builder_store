package org.estore.estore.integration;

import org.estore.estore.dto.response.WalrusUploadResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpMethod.PUT;

@Component
public class WalrusCloudService implements CloudService {

    @Override
    public String upload(MultipartFile file) {
        String walrusUrl = "https://publisher.walrus-testnet.walrus.space/v1/blobs";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        RequestEntity<MultipartFile> requestEntity =
                new RequestEntity<>(file, headers, PUT, URI.create(walrusUrl));
        Map <String, Object> params = new HashMap<>();
        params.put("epochs", 5);
        params.put("send_object_to", "0x0ec7c473cb7327d5eebd8485d45d84ba15ccb96026e234dbd17c9986f5e3f8c1");

        RestTemplate restTemplate = new RestTemplate();
        var response = restTemplate.exchange(walrusUrl, PUT, requestEntity, WalrusUploadResponse.class);
        var walrusUploadResponse = response.getBody();
        return "";
    }
}


//https://publisher.walrus-testnet.walrus.space/v1/blobs?epochs=5&send_object_to=0x0ec7c473cb7327d5eebd8485d45d84ba15ccb96026e234dbd17c9986f5e3f8c1