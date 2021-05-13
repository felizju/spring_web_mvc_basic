package com.spring.mvc.web.board.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@AllArgsConstructor
@ToString
public class Board {

    private static int sequence;

    private int boardNum; // 글번호
    private String writer; // 작성자
    private String title; // 글제목
    private String content; // 글내용
    private int viewCnt; // 조회수

    public Board(){
        this.boardNum = ++sequence;
    }

    public Board(String writer, String title, String content) {
        this();
        this.writer = writer;
        this.title = title;
        this.content = content;
    }

    // 조회 수 상승처리
    public void upViewCnt(){
        this.viewCnt++;
    }
}
