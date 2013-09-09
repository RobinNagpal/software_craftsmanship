package com.cleanCode.service.impl;

import com.cleanCode.service.RegionService;
import com.cleanCode.domain.*;
import com.cleanCode.domain.enums.CustomerType;
import com.cleanCode.domain.enums.SignupType;
import com.cleanCode.domain.util.UserConstants;
import com.cleanCode.dto.*;
import com.cleanCode.service.*;
import com.cleanCode.util.ApplicationUtil;
import com.cleanCode.util.ServiceContext;
import com.cleanCode.util.StringPool;
import com.cleanCode.util.Validator;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.*;
import java.util.logging.Logger;

public class CheckoutServiceImpl {

    private RestaurantRoleService restaurantRoleService;
    private SignupInfoLocalService signupInfoLocalService;
    private UserLocalService userLocalService;
    private LoginService loginService;
    private CountryService countryService;

    private SignupLocalService signupLocalService;
    private static final String DIAMOND_PACKAGE = "diamond_package";
    private static final String SILVER_PACKAGE = "silver_package";
    private static final String GOLD_PACKAGE = "gold_package";
    private static final String DEFAULT_SPONSOR_REP_NUMBER = "994";
    Logger LOGGER;
    private RegionService regionService;


    public void addUserRole(HttpServletRequest httpRequest, Long userId, RestaurantType restaurantType) {
        OrderInfoDTO orderInfoDTO = getOrderInfoFromSession(httpRequest);
        if (RestaurantType.VEG.equals(restaurantType)) {
            updateVegCustomerRestaurantRole(userId, orderInfoDTO.getRestaurantType());
        } else if (RestaurantType.NON_VEG.equals(restaurantType)) {
            updateNonVegCustomerRole(userId, orderInfoDTO.getRestaurantType());
        }
    }


    private void updateVegCustomerRestaurantRole(Long userId, String productName) {

        if (SILVER_PACKAGE.equals(productName)) {
            restaurantRoleService.addVegSilverPackagePurchasedRole(userId);
        } else if (GOLD_PACKAGE.equals(productName)) {
            restaurantRoleService.addVegGoldPackagePurchasedRole(userId);
        } else if (DIAMOND_PACKAGE.equals(productName)) {
            restaurantRoleService.addVegDiamondPackagePurchasedRole(userId);
        }
    }

    private void updateNonVegCustomerRole(Long userId, String productName) {

        if (SILVER_PACKAGE.equals(productName)) {
            restaurantRoleService.addNonVegSilverPackagePurchasedRole(userId);
        } else if (GOLD_PACKAGE.equals(productName)) {
            restaurantRoleService.addNonVegGoldPackagePurchasedRole(userId);
        } else if (DIAMOND_PACKAGE.equals(productName)) {
            restaurantRoleService.addNonVegDiamondPackagePurchasedRole(userId);
        }
    }

    public User purchaseProducts(HttpServletRequest httpRequest, ServiceContext serviceContext) throws Exception {
        OrderInfoDTO orderInfoDTO = getOrderInfoFromSession(httpRequest);
        Company company = ApplicationUtil.getCompany(httpRequest);
        long userId = 0;
        long companyId = company.getCompanyId();
        PaymentInfoDTO paymentInfoDTO = orderInfoDTO.getPaymentInfo();
        AccountInfoDTO accountInfo = orderInfoDTO.getAccountInfo();
        AddressDTO shippingAddressDTO = orderInfoDTO.getShippingAddress();
        boolean coachPoliciesAgree = true;
        Date dateOfBirth;
        String eSignature = StringPool.BLANK;
        Locale locale = httpRequest.getLocale();
        String languageId = locale.getLanguage();
        boolean male = true;
        String middleName = StringPool.BLANK;
        String passwordReminderQuestion = "P90X Test";
        String passwordReminderAnswer = "P90X Test";
        int prefixId = 0;
        int suffixId = 0;
        String source = StringPool.BLANK;
        int orderOID = 0;
        String legacyOrderNo = StringPool.BLANK;
        String ssn = StringPool.BLANK;
        List<Long> selectedProductIds = getSelectedProductIds(orderInfoDTO, true);
        long[] productIds = toPrimitive(selectedProductIds.toArray(new Long[selectedProductIds.size()]));

        int signupTypeId = SignupType.FREE.getTypeId();
        String sponsorRepNumber = StringPool.BLANK;
        int customerTypeId = CustomerType.FREE.getTypeId();
        boolean sweepstakesAgree;
        String emailAddress = StringPool.BLANK;
        String password = StringPool.BLANK;
        String repeatPassword = StringPool.BLANK;
        String screenName = StringPool.BLANK;

        String phoneNumber = StringPool.BLANK;
        final AddressDTO billingAddressDTO = orderInfoDTO.getBillingAddress();
        if (loginService.isLoggedIn(httpRequest) && orderInfoDTO.isLoggedIn()) {
            userId = orderInfoDTO.getUserId();
            SignupInfo signupInfo = signupInfoLocalService.getSignupInfoByUserId(orderInfoDTO.getUserId());
            User user = userLocalService.getUserById(userId);
            signupTypeId = SignupType.CERTIFICATION_ENROLL.getTypeId();
            dateOfBirth = user.getBirthday();
            passwordReminderQuestion = user.getReminderQueryQuestion();
            passwordReminderAnswer = user.getReminderQueryAnswer();
            eSignature = signupInfo.getEsignature();
            sweepstakesAgree = signupInfo.getSweepstakesAgree();
            emailAddress = user.getEmailAddress();
            middleName = user.getMiddleName();
            male = user.getMale();
            customerTypeId = signupInfo.getCustomerTypeId();
            password = user.getPasswordUnencrypted();
            repeatPassword = user.getPasswordUnencrypted();
            screenName = user.getScreenName();
            sponsorRepNumber = signupInfo.getSponsorRepNumber();
            phoneNumber = shippingAddressDTO.getPhoneNumber();
        } else {
            userId = 0;
            phoneNumber = shippingAddressDTO != null ? shippingAddressDTO.getPhoneNumber() : billingAddressDTO.getPhoneNumber();
            emailAddress = accountInfo.getEmailAddress();
            password = accountInfo.getPassword();
            repeatPassword = accountInfo.getRepeatPassword();
            screenName = accountInfo.getScreenName();
            Calendar dob = Calendar.getInstance();
            //To Be replaced by actual date of birth of Customer
            dob.set(Calendar.MONTH, 9);
            dob.set(Calendar.DATE, 1);
            dob.set(Calendar.YEAR, 1980);
            dateOfBirth = dob.getTime();
            if (accountInfo.getReferringId() == null || accountInfo.getReferringId().trim().equals("")) {
                sponsorRepNumber = DEFAULT_SPONSOR_REP_NUMBER;
            } else {
                sponsorRepNumber = accountInfo.getReferringId();
            }
        }

        //Populate Shipping Address Map
        Address shippingAddress = null;
        Map<String, Object> shippingAddressMap = null;

        if (Validator.isNotNull(shippingAddressDTO)) {
            shippingAddress = populateShippingAddress(shippingAddressDTO);
            if (Validator.isNotNull(shippingAddress)) {
                shippingAddressMap = populateAddressMap(shippingAddress);
            }
        }

        //Populate Billing Address Map
        Address billingAddress = null;
        Map<String, Object> billingAddressMap = null;

        if (Validator.isNotNull(shippingAddressDTO) && orderInfoDTO.isShippingAndBillingAddressSame()) {
            billingAddress = populateBillingAddress(shippingAddressDTO);
            if (billingAddressDTO != null && billingAddressDTO.getId() > 0L) {
                billingAddress.setAddressId(billingAddressDTO.getId());
            }
        } else {
            billingAddress = populateBillingAddress(billingAddressDTO);
        }

        if (Validator.isNotNull(shippingAddress) && (shippingAddress.getAddressId() == billingAddress.getAddressId()) && !orderInfoDTO.isShippingAndBillingAddressSame()) {
            billingAddress.setAddressId(0L);
        }

        if (orderInfoDTO.isShippingAndBillingAddressSame() && Validator.isNotNull(shippingAddressDTO) && billingAddressDTO != null && billingAddressDTO.getId() <= 0L) {
            billingAddressMap = shippingAddressMap;
        } else {
            billingAddressMap = populateAddressMap(billingAddress);
        }


        String companyName = company.getName();
        String firstName = shippingAddressDTO != null ? shippingAddressDTO.getFirstName() : billingAddressDTO.getFirstName();
        String lastName = shippingAddressDTO != null ? shippingAddressDTO.getLastName() : billingAddressDTO.getLastName();
        int shippingMethod = 1;
        if (shippingAddressDTO != null && orderInfoDTO.getSelectedShippingMethod() != null) {
            shippingMethod = orderInfoDTO.getSelectedShippingMethod().getId();
        }

        sweepstakesAgree = Boolean.TRUE;
        boolean paymentTermsAndConditionsAccepted = paymentInfoDTO.isPaymentTermsAndConditionsAccepted();
        String expireMonth = String.valueOf(Integer.valueOf(paymentInfoDTO.getExpireMonth()) - 1);

        Map<Long, ProductPriceDetailDTO> productsPricingMap = createProductPricingMap(httpRequest, orderInfoDTO);

        SignupInfoDTO signupInfoDTO = new SignupInfoDTO();
        signupInfoDTO.setProductsPricingMap(productsPricingMap);

        User user = signupLocalService.updateUserSignupMap(userId, companyId, billingAddressMap, orderInfoDTO.isShippingAndBillingAddressSame(),
                paymentInfoDTO.getCreditCardNumber(), paymentInfoDTO.getSecurityCode(),
                expireMonth, paymentInfoDTO.getExpireYear(),
                paymentInfoDTO.getCardHolderFirstName(), paymentInfoDTO.getCardHolderLastName(),
                coachPoliciesAgree, companyName, customerTypeId, dateOfBirth, emailAddress,
                eSignature, firstName, lastName,
                languageId, locale, male, middleName, password, repeatPassword, passwordReminderQuestion,
                passwordReminderAnswer, phoneNumber, phoneNumber, prefixId, productIds, screenName,
                shippingAddressMap, shippingMethod, signupTypeId,
                sponsorRepNumber, ssn, suffixId, sweepstakesAgree, serviceContext,
                paymentTermsAndConditionsAccepted, source, orderOID, legacyOrderNo, signupInfoDTO);
        return user;
    }

    private long[] toPrimitive(Long[] longs) {
        return new long[0];
    }

    private Map<Long, ProductPriceDetailDTO> createProductPricingMap(HttpServletRequest httpRequest, OrderInfoDTO orderInfoDTO) {
        return null;
    }

    private Address populateShippingAddress(AddressDTO addressDTO) throws Exception {
        return populateAddress(addressDTO, AddressDTO.addressType.SHIPPING_ADDRESS);
    }

    private Address populateBillingAddress(AddressDTO addressForm) throws Exception {
        return populateAddress(addressForm, AddressDTO.addressType.BILLING_ADDRESS);
    }

    private Address populateAddress(AddressDTO addressDTO,
                                    AddressDTO.addressType addressType) throws Exception {
        Address address = createEmptyAddressObject();

        address.setAddressId(addressDTO.getId());
        address.setStreet1(addressDTO.getAddressLine1());
        address.setStreet2(addressDTO.getAddressLine2());
        address.setCity(addressDTO.getCity());
        address.setZip(addressDTO.getZipCode());

        if (AddressDTO.addressType.SHIPPING_ADDRESS.equals(addressType)) {
            address.setMailing(true);
            address.setPrimary(true);
        } else {
            address.setMailing(false);
            address.setPrimary(false);
        }

        // Set the country and default to USA if not found
        long countryId = addressDTO.getCountryCode();
        if (countryId == 0) {
            countryId = countryService.getCountry(UserConstants.DEFAULT_COUNTRY_ID).getCountryId();
        }
        address.setCountryId(countryId);

        // Set the state and default if not found
        long regionId = addressDTO.getStateId();
        if (regionId == 0) {
            Country defaultCountry = countryService.getCountry(UserConstants.DEFAULT_COUNTRY_ID);
            Region defaultRegion = regionService.getRegions(defaultCountry.getCountryId()).get(0);
            regionId = defaultRegion.getRegionId();
        }
        address.setRegionId(regionId);

        return address;
    }

    private static Address createEmptyAddressObject() throws Exception {
        return new Address();
    }

    private static Map<String, Object> populateAddressMap(Address address)
            throws Exception {
        Map<String, Object> addressMap = new HashMap<String, Object>();

        Method[] methods = Address.class.getMethods();
        for (Method method : methods) {
            if (isGetter(method)) {
                String key = new String(
                        new char[]{method.getName().charAt(3)})
                        .toLowerCase()
                        + method.getName().substring(4);
                try {
                    addressMap.put(key, method.invoke(address, null));
                } catch (Exception exp) {
                }
            }
        }

        return addressMap;
    }


    public static boolean isGetter(Method method) {
        if (!method.getName().startsWith("get"))
            return false;
        if (method.getParameterTypes().length != 0)
            return false;
        if (void.class.equals(method.getReturnType()))
            return false;
        return true;
    }


    public List<Long> getSelectedProductIdsFromOrderInfo(
            HttpServletRequest request, boolean includeSignup) throws Exception {
        return getSelectedProductIds(getOrderInfoFromSession(request),
                includeSignup);
    }

    private List<Long> getSelectedProductIds(OrderInfoDTO orderInfo,
                                             boolean includeSignup) throws Exception {
        List<Long> productIdsList = new ArrayList<Long>();
        Long productId = orderInfo.getProductId();
        productIdsList.add(productId);

        if (includeSignup && !orderInfo.isLoggedIn()) {
            // Adding Free Sign Up Product in Case User is not a TBB Member
            productIdsList.add(getSignupProductId(SignupType.FREE));
        }
        return productIdsList;
    }

    private Long getSignupProductId(SignupType free) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    private OrderInfoDTO getOrderInfoFromSession(HttpServletRequest httpRequest) {
        return null;
    }
}
