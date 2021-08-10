package com.tomtom.ecommerce.controller;

import com.tomtom.ecommerce.dao.ProductRequestBody;
import com.tomtom.ecommerce.entity.Products;
import com.tomtom.ecommerce.response.AddProductBySeller;
import com.tomtom.ecommerce.serviceImpl.SellerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SellerController {

    @Autowired
    SellerServiceImpl sellerService;

    @PostMapping("/seller/addProduct")
    public ResponseEntity<AddProductBySeller> addProducts(@RequestBody ProductRequestBody productRequestBody) throws Exception {
        return new ResponseEntity<>(sellerService.addProduct(productRequestBody), HttpStatus.ACCEPTED);
    }

    @GetMapping("/getAllProduct")
    public ResponseEntity<List<Products>> getAllProduct() throws Exception {
        return new ResponseEntity<>(sellerService.getAllProducts(), HttpStatus.ACCEPTED);
    }

    @GetMapping("getProductById/{id}")
    public ResponseEntity<Products> getProductById(@PathVariable long id) throws Exception {
        return new ResponseEntity<>(sellerService.getProductById(id), HttpStatus.ACCEPTED);
    }


}
