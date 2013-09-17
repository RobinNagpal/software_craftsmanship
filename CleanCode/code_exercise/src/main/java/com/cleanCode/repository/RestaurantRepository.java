package com.cleanCode.repository;

import com.cleanCode.domain.Restaurant;

import java.util.List;

public interface RestaurantRepository {
    public List<Restaurant> getAllWithInDistanceAndCountryCodeAndActive(double centreLatitude, double centreLongitude, double distance, Long countryCode, Boolean aTrue) ;
}
