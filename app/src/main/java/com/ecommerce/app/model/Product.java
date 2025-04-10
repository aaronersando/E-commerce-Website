package com.ecommerce.app.model;

import lombok.Builder;
import lombok.With;

@Builder
@With
public record Product(
    Integer id,
    String name,
    String description,
    Double price,
    String image_url,
    
    Integer category_id
) {
    

}
