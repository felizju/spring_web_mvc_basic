package com.spring.mvc.web.board.repository;

import com.spring.mvc.web.board.domain.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardMapperTest {

    @Autowired
    private BoardMapper mapper;

    @Test
    void insertArticle(){
        Board board = new Board();
        board.setWriter("마이바티스33");
        board.setTitle("제목제목33");
        board.setContent("내용내용33");

        mapper.insertArticle(board);
    }

    @Test
    void deleteArticle(){
        mapper.deleteArticle(3);
    }

    @Test
    void getArticles(){
        List<Board> list = mapper.getArticles();
        System.out.println("===============================");
        for (Board board : list) {
            System.out.println(board);
        }
    }

    @Test
    void modifyArticle(){
        Board one = mapper.getArticleContent(1);
        System.out.println("===============================");
        System.out.println("one = " + one);
    }

    @Test
    void countTest(){
        mapper.viewCntUp(1);
    }


}