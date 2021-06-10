package com.spring.mvc.web.board.repository;

import com.spring.mvc.web.board.domain.Board;
import com.spring.mvc.web.common.paging.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    //게시글 목록 가져오기
    //1.페이징 없는 버전
    List<Board> getArticles();

    //2.페이징 쿼리 추가버전
    List<Board> getArticles(Criteria criteria);

    //3.검색 쿼리 추가버전
    List<Board> getSearchArticles(Criteria criteria);

    //총 게시물 수 조회
    int getTotalCount(Criteria criteria);

    //게시글 등록
    void insertArticle(Board board);

    //게시글 삭제
    void deleteArticle(int boardNum);

    //게시글 내용 보기
    Board getArticleContent(int boardNum);
    //게시글 첨부파일 경로 얻기
    List<String> getFilePaths(int boardNo);
    
    //게시글 수정
    void modifyArticle(Board board);

    //조회 수 상승
    void viewCntUp(int boardNum);

    //파일 첨부 기능
    void addFile(String filePath);


}
