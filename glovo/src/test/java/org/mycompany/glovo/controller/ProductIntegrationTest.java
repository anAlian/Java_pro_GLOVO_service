package org.mycompany.glovo.controller;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mycompany.glovo.controller.responce.ApiResponse;
import org.mycompany.glovo.dto.order.ProductDto;
import org.mycompany.glovo.model.Product;
import org.mycompany.glovo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class ProductIntegrationTest {
    @Value("${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ProductRepository productRepository;
    @Test
    void shouldGetProductById() {
        Product product = Product.builder()
                .name("product")
                .cost(131.1)
                .orders(1)
                .build();
        Product savedProduct = productRepository.save(product);
        String url = "http://localhost:" + port + "/api/v1/products/" + savedProduct.getId();


        ResponseEntity<ApiResponse<ProductDto>> response = restTemplate.exchange(url, HttpMethod.GET,
                null, new ParameterizedTypeReference<>() {
                });
        ApiResponse<ProductDto> result = response.getBody();

        assert result != null;
        assertEquals(savedProduct.getId(), result.getData().getId());
    }
    @Test
    void shouldAddNewProduct() {

        List<Product> list;

        Product product = Product.builder()
                .name(null)
                .cost(121.1)
                .orders(null)
                .build();

        String url = "http://localhost:" + port + "/api/v1/products";

        HttpEntity<Product> request = new HttpEntity<>(product);

        ResponseEntity<Product> response = restTemplate
                .exchange(url, HttpMethod.POST, request, Product.class);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());


        ResponseEntity<ApiResponse<List<ProductDto>>> getResponse = restTemplate.exchange(url, HttpMethod.GET,
                null, new ParameterizedTypeReference<>() {
                });
        ApiResponse<List<ProductDto>> result = getResponse.getBody();

        assert result != null;
        list = productRepository.findAll();

        assertNotNull(list);
    }
}
