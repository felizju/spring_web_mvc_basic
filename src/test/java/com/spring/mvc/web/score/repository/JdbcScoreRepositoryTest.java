package com.spring.mvc.web.score.repository;

import com.spring.mvc.web.score.domain.Score;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

// 스프링에게 빈을 주입받으려면
@SpringBootTest
class JdbcScoreRepositoryTest {

    @Autowired
    @Qualifier("jr") // 구현체가 여러개일 경우 @Qualifier 로 어떤 걸 구현할 것인지 알려줘야 함.
    private ScoreRepository repository;

    @Test
    void saveTest(){
        Score score = new Score();

        score.setName("도우너");
        score.setKor(78);
        score.setEng(89);
        score.setMath(99);
        score.calcTotalAvg();

        repository.save(score);
    }

    @Test
    void removeTest(){
        repository.remove(4);
    }


}