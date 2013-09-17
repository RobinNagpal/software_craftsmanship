package com.cleanCode.service;

import com.cleanCode.domain.Region;

import java.util.List;

public interface RegionService {
    List<Region> getRegions(long countryId);
}
