package com.cleanCode.domain;

public enum ProductType {
    CONTINUITY, CERTIFICATION, QUALIFICATION;
    
    public static ProductType getByName(String name) {
        for(ProductType productType : ProductType.values()) {
            if(productType.name().equalsIgnoreCase(name)) {
                return productType;
            }
        }
        return null;
    }
}
