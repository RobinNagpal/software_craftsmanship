package com.cleanCode.service;

import com.cleanCode.domain.SignupInfo;

public interface SignupInfoLocalService {
    SignupInfo getSignupInfoByUserId(long userId);
}
