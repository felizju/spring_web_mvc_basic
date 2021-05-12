package com.spring.mvc.web.board.service;

import com.spring.mvc.web.board.domain.Board;
import com.spring.mvc.web.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    public void register(Board board){
        boardRepository.save(board);
    }

    public List<Board> getBoardList(){
        return boardRepository.findAll();
    }

    public void delete(int boardNum){
        boardRepository.remove(boardNum);
    }

    public Board getDetail(int boardNum){
        return boardRepository.findOne(boardNum);
    }

    public void modify(Board board){
        boardRepository.modify(board);
    }

}
