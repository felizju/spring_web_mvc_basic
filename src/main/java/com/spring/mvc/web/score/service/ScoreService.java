package com.spring.mvc.web.score.service;

import com.spring.mvc.web.score.domain.Score;
import com.spring.mvc.web.score.repository.ScoreMapper;
import com.spring.mvc.web.score.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // @Component 와 같음
@RequiredArgsConstructor
public class ScoreService {

    // Controller - > Service -> Repository
    // 중간 잡다한 처리 이후에 Repository 와 연결
//    private final ScoreRepository scoreRepository;
    private final ScoreMapper scoreRepository;

//    @Autowired
//    public ScoreService(@Qualifier("jr") ScoreRepository scoreRepository) {
//        this.scoreRepository = scoreRepository;
//    }


    // 점수 정보 저장 기능
    public void register(Score score){
        score.calcTotalAvg();
        scoreRepository.save(score);
    }

    // 점수 리스트를 받아오는 기능
    public List<Score> getScoreList(){
        return scoreRepository.findAll();
    }

    // 점수 정보 삭제 기능
    public void delete(int stuNum){
        scoreRepository.remove(stuNum);
    }

    // 개별 점수 정보 보기 기능
    public Score getDetail(int stuNum){
        return scoreRepository.findOne(stuNum);
    }

    // 성적 정보 건 수 조회 기능
    public int getCount(){
        return scoreRepository.getCount();
    }


}
