package com.spring.mvc.web.score.repository;

import com.spring.mvc.web.score.domain.Score;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ScoreMapperTest {

    @Autowired
    private ScoreMapper mapper;

    @Test
    void saveTest(){
        Score score = new Score();
        score.setName("마이바티스");
        score.setKor(80);
        score.setEng(88);
        score.setMath(99);
        score.calcTotalAvg();

        mapper.save(score);
    }


    @Test
    void removeTest(){
        mapper.remove(6);
    }


    @Test
    void findAllTest(){
        List<Score> list = mapper.findAll();
        System.out.println("===============================");
        for (Score score : list) {
            System.out.println(score);
        }
        assertEquals(list.size(), 3);
    }

    
    @Test
    void findOneTesT(){
        Score one = mapper.findOne(1);
        System.out.println("===============================");

        System.out.println("검색한 행 = " + one);
    }

}