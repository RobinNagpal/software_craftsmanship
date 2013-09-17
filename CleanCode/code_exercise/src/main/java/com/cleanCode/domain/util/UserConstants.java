package com.cleanCode.domain.util;

public interface UserConstants {
	String PROPS_KEY_SITE_ENV_URL ="host.name.url";
	
	String EMAIL_ADDRESS = "emailAddress";

	String ENROLLMENT_ID = "enrollmentId";
	
	String EMAIL_FROM_TOKEN = "emailFromToken";
	
	String NO_CUSTOMER_AND_NO_REP_NUMBER = "no.customer.number.and.no.rep.number";
	
	String NO_FIRSTNAME = "validation.mandatory.firstname";

	String INVALID_PHONE = "validation.invalid.phone";
	
	String CUSTOMER_EXISTS = "validation.existing.customer";

	String ENROLL_TYPE = "enrollType";
	
	String ENROLLMENT_NEW_CUSTOMER = "Enroll_New_Customer";
	
	String ENROLLMENT_NEW_COACH = "Enroll_New_Coach";
	
	String FIRST_NAME = "firstName";
	
	String LAST_NAME = "lastName";
	
	String PHONE = "phone";
	
	String ENROLEE_EMAIL = "enroleeEmail";
	
	String NON_COACH_CANT_USE_APP = "non.coach.user.cant.use.app";

	String IS_DEVICE_TEXT_ENBLED = "isMsgEnabled";

	String ALREADY_COACH = "validation.existing.coach";

	String ERROR_SAVING_NEW_CUSTOMER = "error.saving.new.customer";

	String ERROR_SAVING_NEW_COACH = "error.saving.new.customer";

	String INVALID_EMAIL = "invalid.email";

	String INVALID_EMAIL_FORMAT = "invalid.email.format";

	String INVALID_CAPTCHA = "invalid.captcha";

	String ENROLLMENT_DETAILS = "enrollmentDetails";

	String EMPTY_EMAIL = "empty.email";
	
	String ERROR_TITLE = "errorTitle";

	String PROSPECT_EXISTS = "prospect.exists";

	String ENROLLMENT_CUSTOMER_EXISTS = "enrollment.customer.exists.message";
	
	String ENROLLMENT_COACH_EXISTS = "enrollment.coach.exists.message";

	String NON_COACH_EMAIL = "non.coach.user.email";

	String INCORRECT_EMAIL = "incorrect.email";

	String INCORRECT_EMAIL_MSG = "incorrect.email.msg";

	String INCORRECT_PASSWORD = "incorrect.password";

	String INCORRECT_PASSWORD_MSG = "incorrect.password.msg";

	String SHOP_NOW = "shopNow";
	
	String PROGRAM_LIST = "programList";

	String CHALLENGE_PACK_CART = "challengePackCart";

	String SHAKEOLOGY_LIST = "shakeologyLimport comist";

	String LOGIN_ATTEMPT_EMAIL = "loginAttemptEmail";

	String NOT_COACH = "notCoach";

	String IS_VISIBLE = "isVisible";

	String CHALLENGE_PACK_CART_PRESENT = "cp.present.cart";

	String ENROLL_WITH_OUT_PURCHASE = "enrollWithoutPurchase";

	String CHALLENGE_PACK_CART_PRICE = "challengePackCartPrice";

	String TOTAL_PRICE = "totalPrice";

	String SKU_PRICE = "skuPrice";

	String SKU_DESCRIPTION = "skuDescription";
	
	String ENROLLING_USER_ALREADY_HAS_ENROLLMENT = "enrolling.user.already.has.enrollment";

	String BODY_BEAST = "Body Beast";

	String ALACARTE_SHOPPING_CART = "alacarteShoppingCart";

	String MEA_ALACARTE_FLOW_ENABLE = "mea.alacarte.flow.enable";
	String ALACART_CODE = "AL";

	String PURCHASE_TYPE_AL = "AL";

	String MEMBERSHIP_LIST = "membershipList";

	String MEMBERSHIP_ARTICLE_MAP = "membershipArticleMap";

	String MEMBERSHIP_PRICE_MAP = "membershipPriceMap";
	
	String MODIFY_ENROLLMENT = "modifyEnrollment";

	String ALACARTE_PRODUCTS = "alacarteProducts";

	String ALACARTE_PRODUCTS_PRICE_MAP = "alacarteProductsPriceMap"; 
	
	String USERNAME_PASSWORD_INCORRECT = "The email address and/or password is incorrect. Please try again.";

	String ORDER_INFO = "orderInfo";
	
	String BASE_URL = "baseURL";

	String ORDER_STORED_IN_SESSION = "orderStoredInSession";

	String LIST_OF_STATES = "listOfStates";

	String LIST_OF_COUNTRIES = "listOfCountries";

	String CURRENT_PAGE = "currentPage";
	
	Long DEFAULT_COUNTRY_ID = 19L;
	
	String DEFAULT_COUNTRY_NAME = "United States";
	
	String DEFAULT_COUNTRY_ABBREVIATION = "USA";

	String USER_CERTIFICATION_CART_DESCRIPTION_FREE = "user.certification.cart.description";
	
	String USER_CERTIFICATION_CART_DESCRIPTION_FREE_DOWNGRADED = "user.certification.cart.description.free.downgraded";

	String USER_CERTIFICATION_CART_DESCRIPTION_EXPEDITED_AIR = "user.certification.cart.description.expedited.air";
	
	String USER_CERTIFICATION_CART_DESCRIPTION_EXPEDITED_GROUND = "user.certification.cart.description.expedited.ground";

	String USER_CERTIFICATION_CART_DESCRIPTION_EXPEDITED_AUTO = "user.certification.cart.description.expedited.auto";

	String USER_QUALIFICATION_CART_DESCRIPTION = "user.qualification.cart.description";
	
	String USER_CONTINUITY_CART_DECSRIPTION = "user.continuity.cart.description";
	
	String USER_INSANITY_CART_DESCRIPTION = "insanity.user.certification.cart.description";

	String EMAIL_INCORRECT = "The email address is incorrect. Please try again.";

	String SELECTED_EVENT_ID = "selectedEventId";
	
	String SELECTED_PRODUCT_ID = "selectedProductId";

	String ACCOUNT_PROFILE = "accountProfile";

	String SCREEN_NAME_IS_ALREADY_TAKEN = "screen-name-is-already-taken";

	String SCREEN_NAME_SHOULD_BE_ALPHANUMERIC = "screen-names-should-be-alphanumeric";
	
	String SCREEN_NAME_LENGTH_ERROR = "screen-names-must-be-between-4-to-20-characters";

	String SCREEN_NAME_GENERIC_ERROR = "screen-name-generic-error";

	String SCREEN_NAME_EMPTY_ERROR = "screen-name-empty-error";

	String PAYMENT_INFO = "paymentInfo";
	
	String PROGRAM_TYPE = "programType";
	
	String COACH_MEMBER_ROLE = "Coach Member";

	String CLUB_MEMBER_ROLE = "Club Member";

	String INVALID_ADDRESS_ERROR = "invalid-address-error";

	String EXISTING_ADDRESS_ERROR = "existing-address-error";
	
	String DOT_ADDRESS = ".address";
	String BUSINESS = "business";
	String PERSONAL = "personal";
	
	
	
	String TBB_SIGNUP_LOGIN ="TBB_SIGNUP_LOGIN";
	
	String TBB_SIGNUP_PASSWORD ="TBB_SIGNUP_PASSWORD";
	
	String PASSWORD_EXCEPTION_CLASS = "com.liferay.portal.UserPasswordException";
	
	String REQ_PARAM_COACH_LOOKUP_TYPE = "coachLookupType";
	
	String REQ_PARAM_COACH_LOOKUP_VALUE = "coachLookupValue";
	
	// User Creation Error Messages
	
	String MSG_KEY_ENTER_VALID_SCREENNAME = "please-enter-a-valid-screen-name";
	String MSG_KEY_ACCOUNT_AVAILABLE = "you-already-have-an-account-with-us-forgot-your-password-click-here";
	String MSG_KEY_LINK_TO_PASSWORD = "user-forgot-password-link";
	String MSG_KEY_USERID_TAKEN = "the-user-id-you-requested-is-already-taken";
	String MSG_KEY_SCREENNAME_TAKEN = "the-screen-name-you-requested-is-already-taken";
	String MSG_KEY_EMAIL_RESERVED = "the-email-address-you-requested-is-reserved";
	String MSG_KEY_PASSWORD_INVALID_LENGTH = "that-password-is-too-short-or-too-long-please-make-sure-your-password-is-between-x-and-512-characters";
	String MSG_KEY_BIRTHDAY ="invalid-birthdate-age";
	String MSG_KEY_PHONENUMBER ="invalid-phonenumber";
	String MSG_KEY_GENERIC_ERROR ="generic-error";
	String MSG_KEY_INVALID_SIGNUP_TOKEN = "invalid-signup-token";
	String MSG_KEY_SSN = "invalid-ssn";
	String ERROR_PROP_INVALID_SIGNUP_TOKEN = "signupToken";
	
	//messages for BD error messages/codes
	String MSG_KEY_INVALID_SPONSOR_REP_NUMBER ="invalid-sponsor-repnumber";
	String MSG_KEY_INVALID_PRICING ="invalid-pricing";
	String MSG_KEY_INVALID_REP_NUMBER ="invalid-rep-number";
	String MSG_KEY_INVALID_CUST_NUMBER ="invalid-cust-number";
	String MSG_KEY_CREATING_REP_RECORD ="invalid-rep-record";
	String MSG_KEY_CREATING_CUST_RECORD ="invalid-cust-record";
	String MSG_KEY_CREATING_ORDER_RECORD ="invalid-order-record";
	String MSG_KEY_CC_DECLINE ="cc-declined";

	String GLOBAL_ERROR = "global-error";

	String SUCCESS_REDIRECTION_FLAG = "successRedirectionFlag";

	String SESSION_PARAM_REFERRING_REP_ID = "referringRepId";
	
	String DEFAULT_EXPIDITED_SHIPPING_PRICE = "16.95";
	
	String DOCUMENT_URL = "document_url";

	String DOCUMENT_URL_BASE = "/c/document_library/get_file?uuid=";
	
	String DOCUMENT_GROUP_ID = "&groupId=";
	String FACILITY_TNC_DOC = "Certification Facility Agreement";
	
	int DEFAULT_MIN = 0;
	
	int DEFAULT_MAX = 100;

	String NEW_FREE_CUSTOMER = "NewFreeCustomer";
	
	//to and from mail address configuration for contact us and facility agreement 
	String MAIL_TO_NAME = "mail_to_name";
	String MAIL_TO_ADDRESS = "mail_to_address";
	String MAIL_FROM_NAME = "mail_from_name";
	String MAIL_FROM_ADDRESS = "mail_from_address";

	String NEWS_ARTICLES = "newsArticles";

	String USER_PROFILE_SUMMARY_INFO = "userProfileSummaryInfo";

	String VIDEO_CONTENT_ARTICLES = "videoContentArticles";

	String VIDEO_CONTENT_LAST_PUBLISH_DATE = "videoContentLastPublishDate";

	String SELECTED_ARTICLE_ID = "selectedArticleId";
	
	String MARKETING_MATERIALS = "marketingMaterials";
	String CERTIFICATION_CONTENT = "certification-content";
	
	String CATEGORY_ID = "categoryId";
	
	String GROUP_NAME = "groupName";

    String CERTIFICATION_VOCAB_NEWS_ANNOUNCEMENT = "certification.p90x.vocabulary.newsannouncement";

    String CERTIFICATION_VOCAB_VIDEOS_CONTENT = "certification.p90x.vocabulary.videoscontent";
    
    String SHIPPING_ADDRESS_TYPE = "Personal";
    
    String MARKETING_ADDRESS_TYPE = "marketing";
    
    String BILLING_ADDRESS_TYPE = "Business";
    
    String BILLING_PHONE_TYPE = "Business";
	
	String SHIPPING_PHONE_TYPE = "Personal";
	
	String P90X_CERT_GRADUATE = "P90XCertGraduate";

	String QUALIFIED_ROLE = "Qual";

    String LIST_OF_LOCATION_RADIUS = "listOfLocationRadius";

    String CLASS_LOCATION_LIST = "classLocationList";

    String CLASS_LOCATION_INFO = "classLocationInfo";

    String CLASS_LOCATION_INFO_JSON = "classLocationInfoJson";

    String EDIT_VIEW = "editView";
}
