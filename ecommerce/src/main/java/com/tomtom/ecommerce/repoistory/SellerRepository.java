package com.tomtom.ecommerce.repoistory;

import com.tomtom.ecommerce.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SellerRepository extends JpaRepository<Products,Long> {

    @Query(value = "select * from products p where p.productid =? and available = true" , nativeQuery = true)
    Products checkIsProductAvailable(long id);

}
