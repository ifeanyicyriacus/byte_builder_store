package org.estore.estore.service;

import org.estore.estore.dto.request.CreateOrderRequest;
import org.estore.estore.dto.request.ItemRequest;
import org.estore.estore.dto.response.CreateOrderResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Test
    @Sql(scripts = {"/db/script.sql"})
    public void testCanPlaceOrder() {
        CreateOrderRequest order = new CreateOrderRequest();
        order.setItems(List.of(new ItemRequest("26943268-c87b-4d41-af5e-2cc83a6d2bc8", 2),
                new ItemRequest("1c7469de-63ec-4299-a160-3e03d3a2e3c8", 5)));
        order.setCartId("7cfbabc9-92f6-427d-b2b0-6acf84aaa881");

        CreateOrderResponse createOrderResponse = orderService.create(order);

        assertNotNull(createOrderResponse);
        assertThat(createOrderResponse.getMessage())
                .containsIgnoringCase("Order Placed Successfully");
    }

}
