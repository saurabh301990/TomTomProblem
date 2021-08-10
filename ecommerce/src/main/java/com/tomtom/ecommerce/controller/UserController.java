package com.tomtom.ecommerce.controller;

import com.tomtom.ecommerce.dao.AddProductToCartRequestBody;
import com.tomtom.ecommerce.response.AddProductToCartResponse;
import com.tomtom.ecommerce.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping("addTocart")
    public ResponseEntity<AddProductToCartResponse> addToCart(@RequestBody AddProductToCartRequestBody addProductToCartRequestBody)
            throws Exception {
        return new ResponseEntity<>(userService.addProductToCart(addProductToCartRequestBody), HttpStatus.ACCEPTED);
    }

}
