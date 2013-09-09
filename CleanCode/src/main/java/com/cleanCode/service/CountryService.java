package com.cleanCode.service;

import com.cleanCode.domain.Country;

public interface CountryService {
    Country getCountry(Long defaultCountryId);
}
