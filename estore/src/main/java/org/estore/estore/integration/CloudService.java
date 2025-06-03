package org.estore.estore.integration;

import org.springframework.web.multipart.MultipartFile;

//@Service
public interface CloudService {
    String upload(MultipartFile file);
}
