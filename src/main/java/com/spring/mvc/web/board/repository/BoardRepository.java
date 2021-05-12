package com.spring.mvc.web.board.repository;

import com.spring.mvc.web.board.domain.Board;

import java.util.List;

public interface BoardRepository {

    // 게시글 저장 기능
    void save(Board board);

    // 게시글 삭제 기능
    void remove(int boardNum);

    // 게시글 하나 조회 기능
    Board findOne(int boardNum);

    // 게시글 전체 보기 기능
    List<Board> findAll();

    // 게시글 수정 기능
    void modify(Board board);

}
