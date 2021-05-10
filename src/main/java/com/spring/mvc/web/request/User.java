package com.spring.mvc.web.request;

import lombok.*;

import java.util.List;

@Setter @Getter
@ToString
//@NoArgsConstructor 실수 방지 위해 @NoArgConstructor 입력하기
public class User {

    private String userId;
    private String userPw;
    private String userName;
    private List<String> hobby;

    public User(){ // 기본 생성자 있어야 함 - 커맨드 객체 생성하기 위해서
        System.out.println("User 커맨드 객체 생성됨!!!");
    }
    public void setUserId(String userId){
        System.out.println("userId Setter 호출됨!!!");
        this.userId = userId;
    }
}
