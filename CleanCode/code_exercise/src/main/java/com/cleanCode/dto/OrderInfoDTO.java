package com.cleanCode.dto;

import com.cleanCode.domain.Product;
import com.cleanCode.domain.Restaurant;
import com.cleanCode.domain.RestaurantType;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;

public class OrderInfoDTO {

    /**
     *
     */
    private static final long serialVersionUID = -4729235882752565045L;


    private Product product;


    private Long productId;

    private Restaurant restaurant;

    private String orderId;

    private AddressDTO shippingAddress;

    private AddressDTO billingAddress;

    private boolean isShippingAndBillingAddressSame;

    private boolean isLoggedIn;

    private boolean isCoach;

    private AccountInfoDTO accountInfo;

    private PaymentInfoDTO paymentInfo;

    private Long userId;

    private BigDecimal productCost = BigDecimal.ZERO.setScale(2);

    private BigDecimal shippingCost = BigDecimal.ZERO.setScale(2);

    private BigDecimal taxRate = BigDecimal.ZERO.setScale(2);

    private BigDecimal tax = BigDecimal.ZERO.setScale(2);

    private BigDecimal productTax = BigDecimal.ZERO.setScale(2);

    private BigDecimal shippingTaxRate = BigDecimal.ZERO.setScale(2);

    private BigDecimal shippingTax = BigDecimal.ZERO.setScale(2);

    private BigDecimal subTotal = BigDecimal.ZERO.setScale(2);

    private String customerNumber;

    private String repNumber;

    private ShippingMethodDTO selectedShippingMethod;

    private List<ShippingMethodDTO> shippingMethods;

    private String productName;

    private String productSku;

    private boolean launchQualification = false;

    private String cartDescription;

    private String eventStartDate;
    private String eventStartDateTime;
    private String eventEndDate;
    private String eventEndDateTime;

    private boolean estimated = false;
    private boolean autoUpgradeForExpediteShipping = false;
    private boolean autoUpgraded = false;

    private BigDecimal discountAmount = BigDecimal.ZERO.setScale(2);
    private RestaurantType restaurantType;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    private BigDecimal finalPrice = BigDecimal.ZERO.setScale(2);

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public boolean isEstimated() {
        return estimated;
    }

    public void setEstimated(boolean estimated) {
        this.estimated = estimated;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductSku() {
        return productSku;
    }

    public void setProductSku(String productSku) {
        this.productSku = productSku;
    }

    public String getCartDescription() {
        return cartDescription;
    }

    public void setCartDescription(String cartDescription) {
        this.cartDescription = cartDescription;
    }

    public BigDecimal getProductCost() {
        return productCost;
    }

    public void setProductCost(BigDecimal productCost) {
        this.productCost = productCost.setScale(2, BigDecimal.ROUND_HALF_UP);
        setSubTotal();
    }

    public BigDecimal getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(BigDecimal shippingCost) {
        this.shippingCost = shippingCost.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal getProductTax() {
        return productTax;
    }

    public void setProductTax(BigDecimal productTax) {
        this.productTax = productTax;
        setTax();
    }

    public BigDecimal getShippingTaxRate() {
        return shippingTaxRate;
    }

    public void setShippingTaxRate(BigDecimal shippingTaxRate) {
        this.shippingTaxRate = shippingTaxRate;
    }

    public BigDecimal getShippingTax() {
        return shippingTax;
    }

    public void setShippingTax(BigDecimal shippingTax) {
        this.shippingTax = shippingTax;
        setTax();
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax() {
        BigDecimal totalTax = BigDecimal.ZERO;
        if(productTax != null){
            totalTax = totalTax.add(productTax);
        }
        if(shippingTax != null){
            totalTax = totalTax.add(shippingTax);
        }
        //Ceiling only gets the right decimal to match on Bydesign side
        this.tax = totalTax.setScale(2, BigDecimal.ROUND_CEILING);
        setSubTotal();
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public AddressDTO getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(AddressDTO shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public AddressDTO getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(AddressDTO billingAddress) {
        this.billingAddress = billingAddress;
    }

    public boolean isShippingAndBillingAddressSame() {
        return isShippingAndBillingAddressSame;
    }

    public void setShippingAndBillingAddressSame(
            boolean isShippingAndBillingAddressSame) {
        this.isShippingAndBillingAddressSame = isShippingAndBillingAddressSame;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

    public boolean isCoach() {
        return isCoach;
    }

    public void setCoach(boolean isCoach) {
        this.isCoach = isCoach;
    }

    public AccountInfoDTO getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(AccountInfoDTO accountInfo) {
        this.accountInfo = accountInfo;
    }

    public PaymentInfoDTO getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(PaymentInfoDTO paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public void setSubTotal() {
        BigDecimal orderTotal = BigDecimal.ZERO;
        if(productCost != null){
            orderTotal = orderTotal.add(productCost);
        }
        if(tax != null){
            orderTotal = orderTotal.add(tax);
        }
        if(selectedShippingMethod != null && selectedShippingMethod.getPrice() != null){
            orderTotal = orderTotal.add(selectedShippingMethod.getPrice());
        }

        orderTotal = orderTotal.subtract(discountAmount);

        subTotal = orderTotal.setScale(2, BigDecimal.ROUND_CEILING);
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public String getEventStartDate() {
        return eventStartDate;
    }

    public void setEventStartDate(String eventStartDate) {
        this.eventStartDate = eventStartDate;
    }

    public String getEventStartDateTime() {
        return eventStartDateTime;
    }

    public void setEventStartDateTime(String eventStartDateTime) {
        this.eventStartDateTime = eventStartDateTime;
    }

    public String getEventEndDate() {
        return eventEndDate;
    }

    public void setEventEndDate(String eventEndDate) {
        this.eventEndDate = eventEndDate;
    }

    public String getEventEndDateTime() {
        return eventEndDateTime;
    }

    public void setEventEndDateTime(String eventEndDateTime) {
        this.eventEndDateTime = eventEndDateTime;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getRepNumber() {
        return repNumber;
    }

    public void setRepNumber(String repNumber) {
        this.repNumber = repNumber;
    }

    public ShippingMethodDTO getSelectedShippingMethod() {
        return selectedShippingMethod;
    }

    public void setSelectedShippingMethod(ShippingMethodDTO selectedShippingMethod) {
        this.selectedShippingMethod = selectedShippingMethod;
        setSubTotal();
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public boolean isLaunchQualification() {
        return launchQualification;
    }

    public void setLaunchQualification(boolean launchQualification) {
        this.launchQualification = launchQualification;
    }

    public List<ShippingMethodDTO> getShippingMethods() {
        return shippingMethods;
    }

    public void setShippingMethods(List<ShippingMethodDTO> shippingMethods) {
        this.shippingMethods = shippingMethods;
    }

    public boolean isAutoUpgradeForExpediteShipping() {
        return autoUpgradeForExpediteShipping;
    }

    public void setAutoUpgradeForExpediteShipping(
            boolean autoUpgradeForExpediteShipping) {
        this.autoUpgradeForExpediteShipping = autoUpgradeForExpediteShipping;
    }

    public boolean isAutoUpgraded() {
        return autoUpgraded;
    }

    public void setAutoUpgraded(boolean autoUpgraded) {
        this.autoUpgraded = autoUpgraded;
    }



    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public BigDecimal getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(BigDecimal finalPrice) {
        this.finalPrice = finalPrice;
    }

    @Override
    public String toString() {
        return "OrderInfoDTO [product=" + product + ", productId=" + productId + ", restaurant="
                + restaurant + ", orderId=" + orderId + ", shippingAddress=" + shippingAddress
                + ", billingAddress=" + billingAddress + ", isShippingAndBillingAddressSame="
                + isShippingAndBillingAddressSame + ", isLoggedIn=" + isLoggedIn + ", isCoach=" + isCoach
                + ", accountInfo=" + accountInfo + ", paymentInfo=" + paymentInfo + ", userId=" + userId
                + ", productCost=" + productCost + ", shippingCost=" + shippingCost + ", taxRate=" + taxRate + ", tax="
                + tax + ", productTax=" + productTax + ", shippingTaxRate=" + shippingTaxRate + ", shippingTax="
                + shippingTax + ", subTotal=" + subTotal + ", customerNumber=" + customerNumber + ", repNumber="
                + repNumber + ", selectedShippingMethod=" + selectedShippingMethod + ", shippingMethods="
                + shippingMethods + ", productName=" + productName + ", launchQualification=" + launchQualification
                + ", cartDescription=" + cartDescription + ", eventStartDate=" + eventStartDate
                + ", eventStartDateTime=" + eventStartDateTime + ", eventEndDate=" + eventEndDate
                + ", eventEndDateTime=" + eventEndDateTime + ", estimated=" + estimated
                + ", autoUpgradeForExpediteShipping=" + autoUpgradeForExpediteShipping + ", autoUpgraded="
                + autoUpgraded + ", discountAmount=" + discountAmount + ", finalPrice=" + finalPrice + "]";
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getRestaurantType() {
        return restaurantType.name();  //To change body of created methods use File | Settings | File Templates.
    }
}
