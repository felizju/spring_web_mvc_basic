package com.spring.mvc.web.board.repository;

import com.spring.mvc.web.board.domain.Board;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Log4j2
public class MemoryBoardRepository implements BoardRepository {

    private static Map<Integer, Board> boardMap = new HashMap<>();

    static{
        boardMap.put(1, new Board("김철수", "제목11", "내용11"));
        boardMap.put(2, new Board("박영희", "제목22", "내용22"));
        boardMap.put(3, new Board("고길동", "제목33", "내용33"));
    }

    // 게시글 전체 보기
    @Override
    public List<Board> getArticles() {
        List<Board> boardList = new ArrayList<>();
        for (int boardNum : boardMap.keySet()) {
            Board board = boardMap.get(boardNum);
            boardList.add(board);
        }
        return boardList;
    }


    // 게시글 등록
    @Override
    public void insertArticle(Board board) {
        boardMap.put(board.getBoardNum(), board);
    }


    // 게시글 삭제
    @Override
    public void deleteArticle(int boardNum) {
        boardMap.remove(boardNum);
    }


    // 게시글 내용 보기
    @Override
    public Board getArticleContent(int boardNum) {
        return boardMap.get(boardNum);
    }


    // 게시글 수정
    @Override
    public void modifyArticle(Board board) {
        boardMap.put(board.getBoardNum(), board);
    }


/*    // 게시글 수정 - 방법2
    @Override
    public void modifyArticle(Board board) {
        Board target = boardMap.get(board.getBoardNum());
        log.info("target: " + target);
        target.setWriter(board.getWriter());
        target.setTitle(board.getTitle());
        target.setContent(board.getContent());
    }*/




}
