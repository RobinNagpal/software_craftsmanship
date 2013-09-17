package com.cleanCode.service;

import javax.servlet.http.HttpServletRequest;

public interface LoginService {
    boolean isLoggedIn(HttpServletRequest httpRequest);
}
