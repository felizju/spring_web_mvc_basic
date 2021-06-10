package com.spring.mvc.web.board.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
@ToString
public class Board {

    private static int sequence;

    private int boardNum; //글번호 board_no
    private String writer; //작성자
    private String title; //글제목
    private String content; //글내용
    private int viewCnt; //조회수 view_cnt
    private Date regDate; // 등록시간

    //신규게시물 여부
    private boolean newArticle;

    //첨부파일 경로 리스트
    private List<String> filePathList;

    public Board(){
//        System.out.println("board constructor call!!");
        this.boardNum = ++sequence;
    }

    public Board(String writer, String title, String content) {
        this();
        this.writer = writer;
        this.title = title;
        this.content = content;
    }

    //조회 수 상승처리
    public void upViewCnt(){
        this.viewCnt++;
    }
}
