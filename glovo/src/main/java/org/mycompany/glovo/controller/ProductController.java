package org.mycompany.glovo.controller;

import lombok.RequiredArgsConstructor;
import org.mycompany.glovo.dto.order.ProductDto;
import org.mycompany.glovo.service.order.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
@RestController
public class ProductController {
    private final ProductService productService;

    @GetMapping()
    public List<ProductDto> getProducts() {
        List<ProductDto> productDtos = productService.getProducts();
        return productDtos;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("productId") Integer productId) {
        ProductDto productDto = productService.getProductById(productId);
        if (productDto != null) {
            return ResponseEntity.ok(productDto);
        }
        return (ResponseEntity<ProductDto>) ResponseEntity.notFound();
    }

    @CrossOrigin("*")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewProduct(@RequestBody ProductDto productDto) {
        productService.save(productDto);
    }

    @PutMapping("/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProductById(@PathVariable("productId") Integer productId, @RequestBody ProductDto productDto) {
        productService.updateProduct(productId, productDto);
    }

    @DeleteMapping("/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProductById(@PathVariable("productId") Integer productId) {
        productService.deleteProduct(productId);
    }
}
