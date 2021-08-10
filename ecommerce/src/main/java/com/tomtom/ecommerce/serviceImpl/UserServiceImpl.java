package com.tomtom.ecommerce.serviceImpl;

import com.tomtom.ecommerce.dao.AddProductToCartRequestBody;
import com.tomtom.ecommerce.entity.CartEntity;
import com.tomtom.ecommerce.entity.Products;
import com.tomtom.ecommerce.entity.UserEntity;
import com.tomtom.ecommerce.repoistory.AddProductToCartRepo;
import com.tomtom.ecommerce.repoistory.SellerRepository;
import com.tomtom.ecommerce.repoistory.UserRepo;
import com.tomtom.ecommerce.response.AddProductToCartResponse;
import com.tomtom.ecommerce.response.UserPaymentResponse;
import com.tomtom.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    AddProductToCartRepo addProductToCartRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    SellerRepository sellerRepository;

    @Override
    @Transactional
    public AddProductToCartResponse addProductToCart(AddProductToCartRequestBody addProductToCartRequestBody) {
        UserEntity userEntity_DBCheck = null;
        UserEntity userEntity;
        CartEntity entity = null;

        // Check if user already Exist in DB basis of Email ID if User Exist pick up registered user
        userEntity_DBCheck = checkIfUserExist(addProductToCartRequestBody.getUser().getEmail());
        if (userEntity_DBCheck != null) {
            userEntity = userEntity_DBCheck;
        } else {
            userEntity = addProductToCartRequestBody.getUser();
        }
        //checking if product Already in Cart , IF already in cart update the product Quantity also checking
        //Product is in records or Not

        CartEntity cartEntity;
        cartEntity = checkIfProductIsInCart(addProductToCartRequestBody.getCartEntity().getProductId());
        if (cartEntity == null) {
            cartEntity = addProductToCartRequestBody.getCartEntity();
        } else {
            int quantity = cartEntity.getQuantity();
            cartEntity.setQuantity(quantity+1);
        }
        cartEntity.setUser(userEntity);
        Products products = checkIfProductAvailable(addProductToCartRequestBody.getCartEntity().getProductId());

        if (products != null)
            entity = addProductToCartRepo.save(cartEntity);

        //Creating Response as per above Operations
        if (entity != null) {
            return new AddProductToCartResponse("Item Added Successfully");

        } else {
            return new AddProductToCartResponse("Item Not Available In Stock");
        }

    }



    public UserEntity checkIfUserExist(String email) {
        return userRepo.findByEmail(email);
    }

    public Products checkIfProductAvailable(long productId) {
        return sellerRepository.checkIsProductAvailable(productId);
    }

    public CartEntity checkIfProductIsInCart(long productID) {
        return addProductToCartRepo.findByProductID(productID);
    }
}
