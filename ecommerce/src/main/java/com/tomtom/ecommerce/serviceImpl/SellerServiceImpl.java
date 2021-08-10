package com.tomtom.ecommerce.serviceImpl;

import com.tomtom.ecommerce.dao.ProductRequestBody;
import com.tomtom.ecommerce.entity.Products;
import com.tomtom.ecommerce.repoistory.SellerRepository;
import com.tomtom.ecommerce.response.AddProductBySeller;
import com.tomtom.ecommerce.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    SellerRepository sellerRepository;

    @Override
    public AddProductBySeller addProduct(ProductRequestBody productsRequestBody) throws Exception {
        Products requestBody = productsRequestBody.getProducts();
        Products prod = sellerRepository.save(requestBody);
        if(prod.getProductID() != null ){
            return new AddProductBySeller("Product has Been Added for Product ID :"+ prod.getProductID());
        }else {
            return  new AddProductBySeller("Product has not Been Added");
        }
    }

    @Override
    public List<Products> getAllProducts() throws Exception {
        return sellerRepository.findAll();
    }

    @Override
    public Products getProductById(Long id) throws Exception {
        return sellerRepository.getById(id);
    }
}
