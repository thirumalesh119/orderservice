package com.myProject.orderservice.DTO;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductDefaultDto {

      Map<String, ProductDto> productDtoMap;

    public Map<String, ProductDto> getProductDtoMap() {
        return productDtoMap;
    }

    public ProductDefaultDto(List<ProductDto> obj){
      productDtoMap=obj.stream().collect(Collectors.toMap(p->p.getProduct_id(),p->p));
  }
}
