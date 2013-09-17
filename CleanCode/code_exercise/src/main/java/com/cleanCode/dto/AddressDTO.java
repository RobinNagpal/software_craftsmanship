package com.cleanCode.dto;

import com.cleanCode.domain.Address;

public class AddressDTO {
    public enum addressType { SHIPPING_ADDRESS, BILLING_ADDRESS; }

    private long id;

    private String firstName;

    private String lastName;

    private String addressLine1;

    private String addressLine2;

    private String addressLine3;


    private String city;

    private long stateId;

    private String stateCode;

    private String stateName;
    private String zipCode;

    private long countryCode = -1L;

    private String countryName;
    private String phoneNumber;

    private long regionCode;

    private int typeId;

    private boolean mailing;

    private boolean primary;

    private String shippingMethodName;

    public String getStateName() {
        return stateName;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public long getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(long countryCode) {
        this.countryCode = countryCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getStateId() {
        return stateId;
    }

    public void setStateId(long stateId) {
        this.stateId = stateId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
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

    public String getShippingMethodName() {
        return shippingMethodName;
    }

    public void setShippingMethodName(String shippingMethodName) {
        this.shippingMethodName = shippingMethodName;
    }

    public boolean isAdressPopulated(){
        return countryCode != -1;
    }

    public long getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(long regionCode) {
        this.regionCode = regionCode;
    }

    @Override
    public String toString() {
        return "AddressDTO [id=" + id + ", firstName=" + firstName
                + ", lastName=" + lastName + ", addressLine1=" + addressLine1
                + ", addressLine2=" + addressLine2 + ", addressLine3="
                + addressLine3 + ", city=" + city + ", stateId=" + stateId
                + ", stateCode=" + stateCode + ", stateName=" + stateName
                + ", zipCode=" + zipCode + ", countryCode=" + countryCode
                + ", countryName=" + countryName + ", phoneNumber="
                + phoneNumber + ", typeId=" + typeId + ", mailing=" + mailing
                + ", primary=" + primary + ", shippingMethodName="
                + shippingMethodName + "]";
    }

    public static AddressDTO valueOf(Address address) {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setId(address.getAddressId());
        addressDTO.setAddressLine1(address.getStreet1());
        addressDTO.setAddressLine2(address.getStreet2());
        addressDTO.setAddressLine3(address.getStreet3());
        addressDTO.setCity(address.getCity());
        addressDTO.setStateId(address.getRegionId());
        addressDTO.setStateCode((address.getRegion() != null) ? address.getRegion().getRegionCode() : null);
        addressDTO.setCountryCode(address.getCountryId());
        addressDTO.setZipCode(address.getZip());
        addressDTO.setTypeId(address.getTypeId());
        addressDTO.setMailing(address.isMailing());
        addressDTO.setPrimary(address.isPrimary());
        return addressDTO;
    }
}
