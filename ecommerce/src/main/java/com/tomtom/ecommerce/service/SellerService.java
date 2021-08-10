package com.tomtom.ecommerce.service;

import com.tomtom.ecommerce.dao.ProductRequestBody;
import com.tomtom.ecommerce.entity.Products;
import com.tomtom.ecommerce.response.AddProductBySeller;

import java.util.List;

public interface SellerService {

    AddProductBySeller addProduct(ProductRequestBody products) throws Exception;

    List<Products> getAllProducts() throws  Exception;

    Products getProductById(Long id) throws  Exception;


}
