package org.mycompany.glovo.model.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("orders")
public class Order {
    @Id
    private Integer id;
    private LocalDate date;
    private Double cost;
    @MappedCollection(idColumn = "orders", keyColumn = "id")
    private List<Product> products;
}
