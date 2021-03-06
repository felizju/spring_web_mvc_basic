package com.spring.mvc.web.board.controller;

import com.spring.mvc.web.board.domain.Board;
import com.spring.mvc.web.board.domain.ModifyBoard;
import com.spring.mvc.web.board.service.BoardService;
import com.spring.mvc.web.common.paging.Criteria;
import com.spring.mvc.web.common.paging.PageMaker;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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

    // 게시글 작성 화면 요청
    @GetMapping("/write")
    public String write(HttpSession session){

//        if (session.getAttribute("loginUser") == null) {
//            return "redirect:/member/sign-in";
//        }
        log.info("/board/write GET 요청");
        return "board/write";
    }

    // 게시글 작성 처리 요청
    @PostMapping("/write")
    public String write(Board board){
        log.info("/board/write POST 요청" + board);

        boardService.insertArticle(board);
        return "redirect:/board/list";
    }

    // 글 목록 요청
    // 1.페이징 처리 없는 처리
/*    @GetMapping("/list")
    public String list(Model model){
        log.info("/board/list GET 요청");
        model.addAttribute("boardList", boardService.getArticles());
        model.addAttribute("count", boardService.getCount());
        return "board/list";
    }*/
    
    // 2.페이징 처리
    // 3.검색 + 페이징 처리
    @GetMapping("/list")
    public String list(Criteria criteria, Model model){
        log.info("/board/list GET 요청" + criteria);
        model.addAttribute("boardList", boardService.getArticles(criteria));

        // 페이지 정보 만들어서 jsp에게 보내기
        model.addAttribute("pageMaker", new PageMaker(criteria, boardService.getTotalCount(criteria)));
        return "board/list";
    }


    // 게시글 정보 삭제 요청
    @GetMapping("/delete")
    public String delete(int boardNum){
        log.info("/board/delete GET 요청");
        boardService.deleteArticle(boardNum);
        return "redirect:/board/list";
    }

    // 게시글 상세보기 요청
    @GetMapping("/detail")
    public String detail(int boardNum, @RequestParam("vf") boolean viewCntFlag, @ModelAttribute("cri") Criteria criteria, Model model){
        Board board = boardService.getArticleContent(boardNum, viewCntFlag);
        model.addAttribute("board", board);
//        model.addAttribute("cri", criteria); @ModelAttribute("cri") 쓰면 생략
        return "board/detail";
    }


    //글 상세보기 요청에서 첨부파일 경로 리스트를 조회하는 비동기 요청
    @GetMapping("/file/{boardNo}")
    @ResponseBody
    public ResponseEntity<List<String>> getfilePaths(@PathVariable int boardNo){
        log.info("/board/file/"+boardNo + "비동기 GET 요청!");
        return new ResponseEntity<>(boardService.getFilePaths(boardNo), HttpStatus.OK);
    }


    // 게시글 수정하기 화면 요청
    @GetMapping("/modify")
    public String modify(int boardNum, @RequestParam("vf") boolean viewCntFlag, Model model){

        model.addAttribute("board", boardService.getArticleContent(boardNum, viewCntFlag));
        return "board/modify";
    }

/*    // 게시글 수정 처리 요청 - 방법1
    @PostMapping("/modify")
    public String modify(Board board, Model model){
        log.info("/board/modify POST 요청: " + board);
        boardService.modifyArticle(board);
        return "redirect:/board/detail?boardNum=" + board.getBoardNum();
    }*/


    // 게시글 수정 처리요청
    @PostMapping("/modify")
    public String modify(ModifyBoard modBoard, @RequestParam("vf") boolean viewCntFlag) {

        Board board = boardService.getArticleContent(modBoard.getBoardNum(), viewCntFlag);
        board.setWriter(modBoard.getWriter());
        board.setTitle(modBoard.getTitle());
        board.setContent(modBoard.getContent());
        boardService.modifyArticle(board);

        return "redirect:/board/detail?boardNum=" + modBoard.getBoardNum() + "&vf=false";
    }
}
