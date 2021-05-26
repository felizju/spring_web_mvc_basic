package com.spring.mvc.web.reply.domain.repository;

import com.spring.mvc.web.reply.domain.Reply;
import com.spring.mvc.web.reply.repository.ReplyMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
class ReplyMapperTest {

    @Autowired
    ReplyMapper replyMapper;

    @Test
    @DisplayName("특정 게시물에 댓글 20개를 삽입")
    void insertTest(){
        for (int i = 0; i <= 20; i++) {
            Reply reply = new Reply();
            reply.setBoardNo(8);
            reply.setReplyText("테스트 댓글"+i);
            reply.setReplyWriter("야옹이");

            replyMapper.save(reply);
        }
    }

    @Test
    @DisplayName("특정 게시물 댓글 1개 조회")
    void readTest(){
        Reply read = replyMapper.read(2);
        System.out.println("read = " + read);
    }
    
    @Test
    @DisplayName("특정 게시물의 댓글 목록을 조회")
    void getListTest(){
        List<Reply> list = replyMapper.getList(8);
        for (Reply reply : list) {
            System.out.println(reply);
        }
    }

    @Test
    @DisplayName("특정 게시물의 댓글 수정")
    void updateTest(){
        Reply reply = replyMapper.read(8);
        reply.setReplyText("수정된 댓글");
        replyMapper.update(reply);

        System.out.println(reply);
    }

    @Test
    @DisplayName("특정 게시물의 댓글 삭제")
    @Transactional @Rollback // 테스트 동안에만 삭제되고, 원본은 원래대로 되돌려줌
    void deleteTest(){
//        replyMapper.delete(4);
//        replyMapper.delete(5);
        replyMapper.delete(6);
    }
}