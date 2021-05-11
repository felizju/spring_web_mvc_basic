package com.spring.mvc.web.score.repository;

import com.spring.mvc.web.score.domain.Score;

import java.util.List;

public interface ScoreRepository {

    // 점수 저장 기능
    void save(Score score);

    // 점수 정보 삭제 기능
    void remove(int stdNum);

    // 개별 점수 조회 기능
    Score findOne(int stdNum);

    // 전체 점수 조회 기능
    List<Score> findAll();

}
