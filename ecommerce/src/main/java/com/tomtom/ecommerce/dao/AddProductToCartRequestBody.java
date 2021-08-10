package com.tomtom.ecommerce.dao;

import com.tomtom.ecommerce.entity.CartEntity;
import com.tomtom.ecommerce.entity.UserEntity;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class AddProductToCartRequestBody {

    private CartEntity cartEntity;

    private UserEntity user;
}
