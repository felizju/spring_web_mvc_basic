package com.spring.mvc.web.reply.api;

import com.spring.mvc.web.reply.domain.Reply;
import com.spring.mvc.web.reply.service.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reply")
@Log4j2
@RequiredArgsConstructor
@CrossOrigin
public class ReplyApiController {   // 비동기 방식 Api

    private final ReplyService replyService;

    // 댓글 목록 조회 요청 처리
    @GetMapping("/{bno}")
    public ResponseEntity<List<Reply>> getList(@PathVariable("bno")  int boardNo) {
        log.info("/api/v1/reply/" + boardNo + "GET!!");
        List<Reply> replies = replyService.getList(boardNo);

        if(replies != null){ // 조회 성공
            return new ResponseEntity<>(replies, HttpStatus.OK);
        }else{ // 조회 실패
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 댓글 등록 처리 요청
    @PostMapping("")
    public ResponseEntity<String> create(@RequestBody Reply reply) { // 비동기로 받을 때는 JSON으로 받아야 하기 떄문에 @RequestBody 붙여야함
        log.info("/api/v1/reply/ POST - " + reply);

        return replyService.register(reply) ? new ResponseEntity<>("insertSuccess", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        /*{
            "boardNo" : 8,
            "replyText" : "API 테스트 댓글",
            "replyWriter" : "어흥이"
        }*/
    }


    // 댓글 수정 요청 처리
    @PutMapping("/{rno}")
    public ResponseEntity<String> modify(@PathVariable("rno") int replyNo, @RequestBody Reply reply){
        reply.setReplyNo(replyNo);
        log.info("/api/v1/reply/" + replyNo + "PUT!!!" + reply);
        return replyService.modify(reply) ? new ResponseEntity<>("modifySuccess", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        /*{
            "replyText" : "API수정테스트입니다."
        }*/
    }


    // 댓글 삭제 요청 처리
    @DeleteMapping("/{rno}")
    public ResponseEntity<String> modify(@PathVariable("rno") int replyNo){
        replyService.remove(replyNo);
        log.info("/api/v1/reply/" + replyNo + "DELETE - ");
        return replyService.remove(replyNo) ? new ResponseEntity<>("deleteSuccess", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
