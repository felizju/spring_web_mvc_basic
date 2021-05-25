package com.spring.mvc.web.board.service;

import com.spring.mvc.web.board.domain.Board;
import com.spring.mvc.web.board.repository.BoardMapper;
import com.spring.mvc.web.board.repository.BoardRepository;
import com.spring.mvc.web.common.paging.Criteria;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

//    private final BoardRepository boardRepository;
    private final BoardMapper boardRepository;

//    @Autowired
//    public BoardService(BoardRepository boardRepository){
//        this.boardRepository = boardRepository;
//    }


    // 게시글 등록
    public void insertArticle(Board board){
        boardRepository.insertArticle(board);
    }


    // 게시글 삭제
    public void deleteArticle(int boardNum){
        boardRepository.deleteArticle(boardNum);
    }


    // 게시글 전체 보기
    public List<Board> getArticles(Criteria criteria){
        // 내림차순 로직
//        List<Board> temp = boardRepository.getArticles();
//        List<Board> boardList = new ArrayList<>();
//        for (int i = temp.size()-1; i >=0 ; i--) {
//            Board board = temp.get(i);
//            boardList.add(board);
//        }
//        return boardList;
//        return boardRepository.getArticles(criteria);

        // 검색쿼리
        return boardRepository.getSearchArticles(criteria);
    }

    // 총 게시물 수 확인
    public int getTotalCount(Criteria criteria){
        return boardRepository.getTotalCount(criteria);
    }


    // 게시글 내용 보기
    public Board getArticleContent(int boardNum, boolean viewFlag){
        Board detail = boardRepository.getArticleContent(boardNum);
        if(viewFlag){
            // detail.upViewCnt();  // Memory 적용
            boardRepository.viewCntUp(boardNum);    // boardMapper 적용
        }
        return detail;
    }


/*    public void modify(Board board){
        boardRepository.modifyArticle(board);
    }*/

    // 게시글 수정
    public void modifyArticle(Board board){
        boardRepository.modifyArticle(board);
    }


}
