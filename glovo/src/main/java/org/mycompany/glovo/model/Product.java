package org.mycompany.glovo.model;
import jakarta.persistence.*;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Double cost;
    private Integer orders;
}
