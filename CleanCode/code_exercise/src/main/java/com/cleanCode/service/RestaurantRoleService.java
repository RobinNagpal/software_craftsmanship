package com.cleanCode.service;

public interface RestaurantRoleService {
    void addVegDiamondPackagePurchasedRole(Long userId);

    void addVegGoldPackagePurchasedRole(Long userId);

    void addVegSilverPackagePurchasedRole(Long userId);

    void addNonVegSilverPackagePurchasedRole(Long userId);

    void addNonVegGoldPackagePurchasedRole(Long userId);

    void addNonVegDiamondPackagePurchasedRole(Long userId);
}
