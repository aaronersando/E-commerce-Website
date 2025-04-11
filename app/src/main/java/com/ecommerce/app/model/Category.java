package com.ecommerce.app.model;

import lombok.Builder;
import lombok.With;

import java.util.Set;

@Builder
@With
public record Category(
    Integer id,
    String name
    // Set<Integer> productIds 
) {

}