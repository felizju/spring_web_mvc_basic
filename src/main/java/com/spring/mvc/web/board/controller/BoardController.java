package com.spring.mvc.web.board.controller;

import com.spring.mvc.web.board.domain.Board;
import com.spring.mvc.web.board.service.BoardService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Log4j2
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }

    // 게시글 등록 화면 요청
    @GetMapping("/register")
    public String register(){
        log.info("/board/register GET 요청");
        return "board/write";
    }

    // 게시글 정보 저장 요청
    @PostMapping("/register")
    public String register(Board board){
        log.info("/board/register POST 요청" + board);
        boardService.register(board);
        return "redirect:/board/list";
    }

    // 게시글 전체 조회
    @GetMapping("/list")
    public String list(Model model){
        List<Board> boardList = boardService.getBoardList();
        log.info("/board/list GET 요청");
        model.addAttribute("boardList", boardList);
        return "board/list";
    }

    // 게시글 정보 삭제 요청
    @GetMapping("/delete")
    public String delete(int boardNum){
        log.info("/board/delete GET 요청");
        boardService.delete(boardNum);
        return "redirect:/board/list";
    }

    // 게시글 세부 정보
    @GetMapping("/detail")
    public String detail(int boardNum, Model model){
        Board board = boardService.getDetail(boardNum);
        model.addAttribute("board", board);
        log.info("/board/detail GET 요청");
        return "board/detail";
    }

    // 게시글 수정 화면 요청
    @GetMapping("/modify")
    public String modify(int boardNum, Model model){
        Board detail = boardService.getDetail(boardNum);
        log.info("/board/modify GET 요청: " + detail);
        model.addAttribute("board", detail);
        return "board/modify";
    }

    // 게시글 수정 반영 요청
    @PostMapping("/modify")
    public String modify(Board board, Model model){
        log.info("/board/modify POST 요청: " + board);
        boardService.modify(board);
        return "redirect:/board/detail?boardNum=" + board.getBoardNum();
    }


}
