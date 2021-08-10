package com.tomtom.ecommerce.dao;

import com.tomtom.ecommerce.entity.Products;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class ProductRequestBody {

    private Products products;
}
