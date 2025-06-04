package util;

import org.estore.estore.dto.request.AddProductRequest;
import org.estore.estore.dto.request.CreateOrderRequest;
import org.estore.estore.dto.request.ItemRequest;
import org.springframework.mock.web.MockMultipartFile;

import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TestUtils {

    public static CreateOrderRequest buildCreateOrder() {
        CreateOrderRequest order = new CreateOrderRequest();
        order.setItems(List.of(
                new ItemRequest("26943268-c87b-4d41-af5e-2cc83a6d2bc8", 2),
                new ItemRequest("1c7469de-63ec-4299-a160-3e03d3a2e3c8", 5)));
        order.setCartId("7cfbabc9-92f6-427d-b2b0-6acf84aaa881");
        return order;
    }

    public static AddProductRequest buildAddProduct() {
        String imagePath = "/home/civm/Documents/Dynamite/sandbox/byte_builder_store/estore/src/test/resources/assets/iPhoneImage.jpg";
        String videoPath = "/home/civm/Documents/Dynamite/sandbox/byte_builder_store/estore/src/test/resources/assets/iPhoneVideo.mp4";
        Path image = Paths.get(imagePath);
        Path video = Paths.get(videoPath);

        try (
                var imageStream = Files.newInputStream(image);
                var videoStream = Files.newInputStream(video)) {
            AddProductRequest productRequest = new AddProductRequest();
            productRequest.setName("Nokia Phone X20");
            productRequest.setDescription("Nokia X20 5G 8Gb RAM 125G storage");
            productRequest.setPrice(new BigDecimal(120_000));
            productRequest.setQuantity(15L);
            productRequest.setMedia(List.of(
                    new MockMultipartFile("media", imageStream),
                    new MockMultipartFile("media", videoStream)
            ));
            return productRequest;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}