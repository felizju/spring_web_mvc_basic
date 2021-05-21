package com.spring.mvc.web.board.repository;

import com.spring.mvc.web.board.domain.Board;
import com.spring.mvc.web.common.paging.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    // 게시글 등록
    void insertArticle(Board board);

    // 게시글 삭제
    void deleteArticle(int boardNum);

    // 게시글 내용 보기
    Board getArticleContent(int boardNum);

    // 게시글 전체 보기 - 페이징 없는 버전
     List<Board> getArticles();

    // 게시글 전체 보기 - 페이징 처리 버전
    List<Board> getArticles(Criteria criteria);

    // 총 게시물 수 조회
    int getTotalCount();

    // 게시글 수정
    void modifyArticle(Board board);

    // 조회 수
    void viewCntUp(int boardNum);

}
