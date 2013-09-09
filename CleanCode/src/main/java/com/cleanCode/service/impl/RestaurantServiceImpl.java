package com.cleanCode.service.impl;

import com.cleanCode.domain.DistanceUnits;
import com.cleanCode.domain.Restaurant;
import com.cleanCode.repository.RestaurantRepository;
import com.cleanCode.service.RestaurantService;

import java.util.List;

public class RestaurantServiceImpl implements RestaurantService {

    private RestaurantRepository restaurantRepository;

    @Override
    public List<Restaurant> getAllWithInDistanceForCountry(double centreLatitude, double centreLongitude, double distance, DistanceUnits distanceUnits, Long countryCode){
        if(distanceUnits!=null && DistanceUnits.KILOMETERS.equals(distanceUnits)){
            distance = DistanceUnits.convertToMilesFromKms(distance);
        }
        List<Restaurant> martDetails = getRepository().getAllWithInDistanceAndCountryCodeAndActive(centreLatitude,centreLongitude,distance, countryCode, Boolean.TRUE);
        return martDetails;
    }

    private RestaurantRepository getRepository() {
        return restaurantRepository;
    }



}
