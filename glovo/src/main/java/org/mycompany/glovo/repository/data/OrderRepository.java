package org.mycompany.glovo.repository.data;

import org.mycompany.glovo.model.data.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface OrderRepository extends CrudRepository<Order, Integer> {
    Page<Order> findAll(Pageable pageable);
}
