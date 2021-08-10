package com.tomtom.ecommerce.repoistory;

import com.tomtom.ecommerce.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddProductToCartRepo extends JpaRepository<CartEntity,Long> {

        @Query(value = "select * from cart c where c.product_id = ? and c.payment =false" , nativeQuery = true)
        CartEntity findByProductID(long productID);

        @Query(value = "select * from cart c where c.user_id = ? and c.payment =false" , nativeQuery = true)
        List<CartEntity> findByUserId(long userId);

        @Query(value = "select * from cart c where c.product_id = ? and c.user_id =? and c.payment = false" , nativeQuery = true)
        CartEntity findByProductByProductIdAndUserId(long productID , long userID);

}
