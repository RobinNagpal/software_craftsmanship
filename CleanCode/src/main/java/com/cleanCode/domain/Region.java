package com.cleanCode.domain;

public class Region {
    private long pk;
    private long regionId;
    private long countryId;
    private String regionCode;
    private String name;
    private boolean active;

    public long getPrimaryKey() {
        return pk;
    }

    public void setPrimaryKey(long pk) {
        this.pk = pk;
    }

    public long getRegionId() {
        return regionId;
    }

    public void setRegionId(long regionId) {
        this.regionId = regionId;
    }

    public long getCountryId() {

        return countryId;
    }

    public void setCountryId(long countryId) {
        this.countryId = countryId;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getActive() {
        return active;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
