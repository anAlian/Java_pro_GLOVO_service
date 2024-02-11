package org.mycompany.glovo.dto.order;

import lombok.*;

import java.time.LocalDate;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class OrderDto {
    private Integer id;
    private LocalDate date;
    private  Double cost;
    private List <ProductDto> products;
}
