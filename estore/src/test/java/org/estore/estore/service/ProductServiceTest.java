package org.estore.estore.service;

import org.estore.estore.dto.request.AddProductRequest;
import org.estore.estore.dto.request.UpdateProductRequest;
import org.estore.estore.dto.response.AddProductResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static util.TestUtils.buildAddProduct;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    public void testCanAddProduct() {
        AddProductRequest productRequest = new AddProductRequest();
        AddProductResponse productResponse = productService.add(buildAddProduct());
        assertThat(productResponse).isNotNull();
        assertThat(productResponse.getMedia()).isNotNull();
    }

    @Test
    public void testCanUpdateProduct() {
        UpdateProductRequest updateProductRequest = new UpdateProductRequest();
        updateProductRequest.setName("");
    }
}
