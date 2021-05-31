package com.spring.mvc.web.reply.repository;

import com.spring.mvc.web.common.paging.Criteria;
import com.spring.mvc.web.reply.domain.Reply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReplyMapper {

    // 댓글 입력
    int save(Reply reply);

    // 댓글 수정
    int update(Reply reply);

    // 댓글 삭제
    int delete(int replyNo);

    // 단일 댓글 조회
    Reply read(int replyNo);


    // 특정 게시글의 댓글 목록 조회
    /**
     * Mybatis Mapper 는 기본적으로 1개의 매개값만 받을 수 있음.
     * 그러나 @Param 을 통해 여러개를 처리할 수 있게 추가됨. (과거에는 Map 이용해서 사용)
     * @param boardNum
     * @param cri
     * @return
     */
    List<Reply> getList(@Param("bno") int boardNum
                        , @Param("cri") Criteria cri);


    // 특정 게시글의 댓글 총 개수 조회
    int getCount(int boardNo);

}
