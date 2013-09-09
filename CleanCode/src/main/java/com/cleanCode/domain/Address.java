package com.cleanCode.domain;

public class Address {
    public long getAddressId() {
        return 0;
    }

    public void setAddressId(long l) {
        //To change body of created methods use File | Settings | File Templates.
    }

    private String street1;
    private String street2;
    private String street3;
    private String city;
    private String zip;
    private long regionId;
    private long countryId;
    private String type;
    private boolean mailing;
    private boolean primary;
    private String countryCode;
    private String regionCode;
    private Region region;
    private int typeId;




     public String getStreet1() {
        return street1;
    }
    public void setStreet1(String street1) {
        this.street1 = street1;
    }
    public String getStreet2() {
        return street2;
    }
    public void setStreet2(String street2) {
        this.street2 = street2;
    }
    public String getStreet3() {
        return street3;
    }
    public void setStreet3(String street3) {
        this.street3 = street3;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getZip() {
        return zip;
    }
    public void setZip(String zip) {
        this.zip = zip;
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
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public boolean isMailing() {
        return mailing;
    }
    public void setMailing(boolean mailing) {
        this.mailing = mailing;
    }
    public boolean isPrimary() {
        return primary;
    }
    public void setPrimary(boolean primary) {
        this.primary = primary;
    }
    public String getCountryCode() {
        return countryCode;
    }
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    public String getRegionCode() {
        return regionCode;
    }
    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Region getRegion(){
        return region;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }



}
