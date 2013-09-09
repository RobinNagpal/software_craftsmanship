package com.cleanCode.domain;

import java.util.Arrays;
import java.util.List;

public enum ProductCategory {

    COMPLETE_CERTIFICATION_PACKAGE {
        @Override
        public List<ProductType> getProductTypes() {
            return Arrays.asList(ProductType.CERTIFICATION, ProductType.QUALIFICATION);
        }
    },
    
    QUALIFICATION {
        @Override
        public List<ProductType> getProductTypes() {
            return Arrays.asList(ProductType.QUALIFICATION);
        }
    },
    
    CONTINUITY {
        @Override
        public List<ProductType> getProductTypes() {
            return Arrays.asList(ProductType.CONTINUITY);
        }
    },
    
    CERTIFICATION {
        @Override
        public List<ProductType> getProductTypes() {
            return Arrays.asList(ProductType.CERTIFICATION);
        }
    };
    
    public abstract List<ProductType> getProductTypes();
}
