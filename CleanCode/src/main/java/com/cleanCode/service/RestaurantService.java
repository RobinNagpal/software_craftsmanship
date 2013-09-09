package com.cleanCode.service;


import com.cleanCode.domain.DistanceUnits;
import com.cleanCode.domain.Restaurant;

import java.util.List;

public interface RestaurantService {

    List<Restaurant> getAllWithInDistanceForCountry(double centreLatitude, double centreLongitude, double distance, DistanceUnits distanceUnits, Long countryCode);
}
