package org.mycompany.glovo.repository.data;

import org.mycompany.glovo.model.data.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    Page<Product> findAll(Pageable pageable);
}
