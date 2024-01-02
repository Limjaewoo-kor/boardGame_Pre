package com.prepot.service;

import com.prepot.domain.Member;


public interface LoginService {
    Member login(String loginId, String password);

}
