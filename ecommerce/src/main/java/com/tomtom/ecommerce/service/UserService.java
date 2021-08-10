package com.tomtom.ecommerce.service;

import com.tomtom.ecommerce.dao.AddProductToCartRequestBody;
import com.tomtom.ecommerce.response.AddProductToCartResponse;
import com.tomtom.ecommerce.response.UserPaymentResponse;

public interface UserService {


    AddProductToCartResponse addProductToCart(AddProductToCartRequestBody addProductToCartRequestBody);


}
