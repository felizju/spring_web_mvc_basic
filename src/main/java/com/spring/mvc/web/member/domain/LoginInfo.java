package com.spring.mvc.web.member.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class LoginInfo {

    private String account; // 계정
    private String password; // 비밀번호
    private boolean autoLogin; // 자동로그인 여부
}