package com.spring.mvc.web.board.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class Board {

    private static int sequence;

    private int boardNum; // 게시글 번호
    private String name; // 작성자
    private String title; // 제목
    private String content; // 내용
    private int count; // 조회 수

    public Board(){
        this.boardNum = ++sequence;
    }

    public Board(String name, String title, String content) {
        this();
        this.name = name;
        this.title = title;
        this.content = content;
    }

}
