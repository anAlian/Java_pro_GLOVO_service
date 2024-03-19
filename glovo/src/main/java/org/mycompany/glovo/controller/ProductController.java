package org.mycompany.glovo.controller;

import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.mycompany.glovo.controller.order.AppConstants;
import org.mycompany.glovo.controller.responce.ApiResponse;
import org.mycompany.glovo.dto.order.ProductDto;
import org.mycompany.glovo.service.ProductService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
@RestController
public class ProductController {
    private final ProductService productService;

    @CrossOrigin("*")
    @GetMapping()
    public ApiResponse<List<ProductDto>> getProducts(@RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
                                                     @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
                                                     @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
                                                     @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.DESC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        ApiResponse<List<ProductDto>> response = new ApiResponse<>();
        List<ProductDto> productDtos = productService.getProducts(pageable);
        if (!CollectionUtils.isEmpty(productDtos)) {
            response.setSuccess(true);
            response.setData(productDtos);
        }
        return response;
    }

    @CrossOrigin("*")
    @GetMapping("/{productId}")
    public ApiResponse<ProductDto> getProductById(@PathVariable("productId") Integer productId) {
        ApiResponse<ProductDto> response = new ApiResponse<>();
        ProductDto productDto = productService.getProductById(productId);
        if (productDto != null) {
            response.setSuccess(true);
            response.setData(productDto);
        }
        return response;
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
