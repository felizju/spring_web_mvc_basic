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

    @Override
    public void save(Board board) {
        boardMap.put(board.getBoardNum(), board);
        log.info(boardMap);
    }

    @Override
    public void remove(int boardNum) {
        boardMap.remove(boardNum);
    }

    @Override
    public Board findOne(int boardNum) {
        return boardMap.get(boardNum);
    }

    @Override
    public List<Board> findAll() {
        List<Board> boardList = new ArrayList<>();
        for (int key : boardMap.keySet()) {
            boardList.add(boardMap.get(key));
        }
        return boardList;
    }

    @Override
    public void modify(Board modArticle) {
        Board target = boardMap.get(modArticle.getBoardNum());
        log.info("target: " + target);
        target.setName(modArticle.getName());
        target.setTitle(modArticle.getTitle());
        target.setContent(modArticle.getContent());
    }


}
