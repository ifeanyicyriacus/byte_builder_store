package org.estore.estore.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class WalrusCloudServiceTest {

    @Autowired
    private CloudService cloudService;

    @Test
    void testCanUploadFile(){
        String fileLocation = "/home/civm/Documents/Dynamite/sandbox/byte_builder_store/estore/src/test/resources/assets/iPhoneImage.jpg";
        Path path = Paths.get(fileLocation);

        try(var inputStream = Files.newInputStream(path)){
            MultipartFile file = new MockMultipartFile(
                    "image", inputStream);
            String data = cloudService.upload(file);
            assertThat(data).isNotNull();
            assertThat(data).isNotEmpty();

        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }

}
