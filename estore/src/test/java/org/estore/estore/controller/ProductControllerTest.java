package org.estore.estore.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;

public class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCanAddProduct() throw Exception{
        String imagePath = "/home/civm/Documents/Dynamite/sandbox/byte_builder_store/estore/src/test/resources/assets/iPhoneImage.jpg";
        String videoPath = "/home/civm/Documents/Dynamite/sandbox/byte_builder_store/estore/src/test/resources/assets/iPhoneVideo.mp4";

        Path image = Paths.get(imagePath);
        Path video = Paths.get(videoPath);

        mockMvc.perform(multipart("/api/v1/product")
                .file("media", new MockMultipartFile()))
    }


    private static MultiValueMap<String, String> buildFormFields() {
        MultiValueMap<String, String> fields = new LinkedMultiValueMap<>();
        fields.add("name", "iphone");
        fields.add("price", BigDecimal.valueOf(1000).toString());
        fields.add("description", "iPhone 16 pro max");
        fields.add("quantity", "10");
    }
}
