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
    public ResponseEntity<List<ProductDto>> getProducts() {
        List<ProductDto> products = productService.getProducts();
        if (products != null) {
            return ResponseEntity.ok(products);
        }
        return (ResponseEntity <List<ProductDto>>) ResponseEntity.notFound();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("productId") Integer productId) {
        ProductDto product = productService.getProductById(productId);
        if (product != null) {
            return ResponseEntity.ok(product);
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
