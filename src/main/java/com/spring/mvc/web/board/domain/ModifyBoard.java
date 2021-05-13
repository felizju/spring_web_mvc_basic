package com.spring.mvc.web.board.domain;

import lombok.Getter;
import lombok.Setter;

// DTO 역할
@Getter @Setter
public class ModifyBoard {

    private int boardNum; // 글번호
    private String writer; // 작성자
    private String title; // 글제목
    private String content; // 글내용

}
