package com.spring.mvc.web.request;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

// 스프링 컨테이너에 해당 클래스의 객체가 빈(컨트롤러빈)으로 등록됨
@Controller
public class RequestController {

    // 요청 처리 메서드 (서블릿 역할)
    // 해당 URL에 따른 GET요청을 처리하게 함
    // @RequestMapping(value = "/req/test", method = RequestMethod.POST)     // 예전방식
    @GetMapping("/req/test")    // 최신방식
    public String test(){
        System.out.println("## /req/test GET요청 발생!!");
//        return "/WEB-INF/views/test.jsp"; // 리턴은 뷰 파일 포워딩 개념
        return "test";
    }

    // 요청 URI : /request/req-ex
    @GetMapping("/request/req-ex")
    public String reqEx(){
        return "request/req-ex";
    }

    @GetMapping("/request/basic")
    public String basicGET(){
        System.out.println("/basic GET 요청 발생!!");
        return "request/req-ex";
    }

    @PostMapping("/request/basic")
    public String basicPOST(){
        System.out.println("/basic POST 요청 발생!!");
        return "request/req-ex";
    }

    // 요청 파라미터 받기1 - (/req/basic ? xxx=yyy&zzz=yyy)
    @GetMapping("/request/param")
    public String param(HttpServletRequest request){
        String money = request.getParameter("money");
        System.out.println("money = " + money);
        String name = request.getParameter("name");
        System.out.println("name = " + name);
        return "test";
    }

    // 요청 파라미터 받기2 - @RequestParam 이용하기
    @GetMapping("/request/param2")
//    public String param2(@RequestParam int money){
    // 자바 변수명은 apple로 사용, requestParam은 money로 적용하고 싶을 경우, 같을 경우 @RequestParam 생략 가능
    public String param2(@RequestParam("money") int apple
                            , @RequestParam String id
                            , @RequestParam String addr){
        System.out.println("apple = " + (apple*2));
        System.out.println("id = " + id);
        return "test";
    }

    // 요청 파라미터 받기3 - 커맨드 객체 사용
    @GetMapping("/request/param3")
    public String param3(User user){ // setter의 필드명 확인함
        System.out.println("user = " + user);
        return "test";
    }

    @GetMapping("/request/join-form")
    public void form(){
        // return의 jsp 경로와 GetMapping URL 같을 경우 void로 리턴타입 기재 후 return 생략 가능함
//        return "request/join-form";
    }


    //==================== Quiz ==================//
    @GetMapping("/request/quiz")
    public String quiz() {
        return "request/req-quiz";
    }

    @PostMapping("/request/quiz")
    public String quiz(String userId, String userPw) {
        return userId.equals("abc1234") && userPw.equals("xxx4321")
                ? "request/success" : "request/fail";
    }

}
