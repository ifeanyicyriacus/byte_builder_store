package org.estore.estore.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MediaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetMedia() throws Exception {
        String blobId = "V4L9mlmYNFcxBOB78pHTF_WtaU8tFhJ5la-SEW8Ex-k";
        mockMvc.perform(get("/api/v1/media")
                        .queryParam("blobId", blobId))
                .andExpect(status().is2xxSuccessful())
                .andDo(print());
    }
}
