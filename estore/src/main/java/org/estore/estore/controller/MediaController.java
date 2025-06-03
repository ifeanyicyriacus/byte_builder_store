package org.estore.estore.controller;

import lombok.AllArgsConstructor;
import org.estore.estore.integration.CloudService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;

@RestController
@RequestMapping("/api/v1/media")
@AllArgsConstructor
public class MediaController {

    private final CloudService cloudService;

    @GetMapping(produces = {
            MediaType.IMAGE_PNG_VALUE,
            MediaType.APPLICATION_OCTET_STREAM_VALUE})
    public ResponseEntity<?> getMedia(@PathVariable String blobId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(cloudService.getFileBy(blobId));
    }
}
