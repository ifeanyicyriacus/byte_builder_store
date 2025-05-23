package org.estore.estore.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class AddProductRequest {

    private String name;
    private BigDecimal          price;
    private long                quantity;
    private List<MultipartFile> media;
    private String description;
}
