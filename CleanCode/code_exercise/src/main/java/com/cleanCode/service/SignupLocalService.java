package com.cleanCode.service;

import com.cleanCode.domain.User;
import com.cleanCode.dto.SignupInfoDTO;
import com.cleanCode.util.ServiceContext;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

public interface SignupLocalService {

    User updateUserSignupMap(long userId, long companyId, Map<String, Object> billingAddressMap, boolean shippingAndBillingAddressSame, String creditCardNumber, String securityCode, String expireMonth, String expireYear, String cardHolderFirstName, String cardHolderLastName, boolean coachPoliciesAgree, String companyName, int customerTypeId, Date dateOfBirth, String emailAddress, String eSignature, String firstName, String lastName, String languageId, Locale locale, boolean male, String middleName, String password, String repeatPassword, String passwordReminderQuestion, String passwordReminderAnswer, String phoneNumber, String phoneNumber1, int prefixId, long[] productIds, String screenName, Map<String, Object> shippingAddressMap, int shippingMethod, int signupTypeId, String sponsorRepNumber, String ssn, int suffixId, boolean sweepstakesAgree, ServiceContext serviceContext, boolean paymentTermsAndConditionsAccepted, String source, int orderOID, String legacyOrderNo, SignupInfoDTO signupInfoDTO);
}
