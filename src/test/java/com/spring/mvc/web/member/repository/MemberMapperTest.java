package com.spring.mvc.web.member.repository;

import com.spring.mvc.web.member.domain.Auth;
import com.spring.mvc.web.member.domain.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberMapperTest {

    @Autowired
    MemberMapper mapper;

    @Test
    @DisplayName("회원가입에 성공")
    void registerTest(){
        // build 패턴으로 생성자의 순서를 지키지 않고 넣을 수 있고, setter 불편함을 보완할 수 있음.
        Member member = Member.builder().account("abc4321").name("고길동").email("aaa343@gmail.com").password("123adf").auth(Auth.COMMON).build();
        System.out.println("member = " + member);
        mapper.register(member);
        Member findUser = mapper.getUser(member.getAccount());
        assertEquals(member.getAccount(), findUser.getAccount());
    }

    @Test
    @DisplayName("아이디, 이메일 중복확인에 성공")
    void duplicateTest(){
        String inputAccount = "admin";

        Map<String, Object> datas = new HashMap<>();
        datas.put("type", "account");
        datas.put("keyword", inputAccount);

        int result = mapper.isDuplicate(datas);

        assertTrue(result == 1);
    }

    @Test
    @DisplayName("비밀번호가 암호화되어야 함")
    void encodePwTest(){
        // 평문 패스워드
        String rawPw = "ddd555";

        // 패스워드 인코딩
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodePw = encoder.encode(rawPw);

        System.out.println("================================");
        System.out.println("평문 비밀번호 "+ rawPw);
        System.out.println("암호화 비밀번호 "+encodePw);
    }

    @Test
    @DisplayName("비밀번호가 암호화된 상태로 회원가입에 성공")
    void regTest2(){
        Member member = Member.builder().account("banana").email("bbb222@naver.com").name("바나나").password(new BCryptPasswordEncoder().encode("bbb1234")).auth(Auth.COMMON).build();
        mapper.register(member);

    }

    @Test
    @DisplayName("로그인 검증을 수행")
    void loginTest(){
        // 로그인 시도 아이디
        String inputId = "banana";
        // 로그인 시도 패스워드
        String inputPw = "bbb1234";

        // 로그인 시도 아이디를 기반으로 회원정보를 조회
        Member member = mapper.getUser(inputId);
        if(member != null){
            // db에 저장된 비번
            String dbPw = member.getPassword();

            // 암호화된 비번을 디코딩해서 비교
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

            if(encoder.matches(inputPw, dbPw)){ // encoder.matches(평문pw, dbpw) 비교
                System.out.println("로그인 성공!");
            }else{
                System.out.println("비밀번호 오류!");
            }
        }else{
            System.out.println("회원가입을 먼저 진행하세요");
        }


    }



}