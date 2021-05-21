package com.spring.mvc.web.board.repository;

import com.spring.mvc.web.board.domain.Board;
import com.spring.mvc.web.common.paging.Criteria;
import org.junit.jupiter.api.DisplayName;
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

    @Test
    @DisplayName("300개의 게시글을 등록해야 한다.")
    void bulkInsert(){
        for (int i = 0; i < 300; i++) {
            Board board = new Board();
            board.setTitle("테스트제목"+i);
            board.setContent("테스트내용"+i);
            board.setWriter("USER"+i);

            mapper.insertArticle(board);
        }
    }

    @Test
    @DisplayName("페이지 정보에 따른 게시물을 조회해야 한다.")
    void pagingTest1(){
        System.out.println("========================================================================");
        Criteria criteria = new Criteria(2, 30);
        for (Board article : mapper.getArticles(criteria)) {
            System.out.println(article);
        }
        System.out.println("========================================================================");
    }

}