package com.spring.mvc.web.score.controller;

import com.spring.mvc.web.score.domain.Score;
import com.spring.mvc.web.score.service.ScoreService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Log4j2 // 로그를 만들어주는 롬복 어노테이션
@RequestMapping("/score") // 모든 시작 URL이 /score~~~로 시작함
public class ScoreController {

    // 화면 요청
    private final ScoreService scoreService;

    // 생성자 주입
    @Autowired
    public ScoreController(ScoreService scoreService){
        this.scoreService = scoreService;
    }

    // 점수 등록 화면 요청
    @GetMapping("/register")
    public String register(){
        log.info("/score/register GET 요청 발생! - ");
        return "score/write-form";
    }

    // 점수 정보 저장 요청
    @PostMapping("/register")
    public String register(Score score){
        log.info("/score/register POST 요청 발생! - " + score);
        scoreService.register(score); // 서비스에게 보냄 (중간다리)

        return "redirect:/score/list"; // 재요청 -> 리다이렉트 : 경로가 아닌 URL임
    }

    // 점수 전체 조회 요청
    @GetMapping("/list")
    public String list(Model model){
        List<Score> scoreList = scoreService.getScoreList();
        log.info("/score/list GET 요청! - " + scoreList);
        model.addAttribute("scoreList", scoreList);
        return "score/write-form";
    }

    // 점수 정보 삭제 요청
    @GetMapping("/delete")
    public String delete(int stuNum){
        log.info("/score/delete GET : - " + stuNum);
        scoreService.delete(stuNum);
        return "redirect:/score/list";
    }

    // 점수 정보
    @GetMapping("/detail")
    public String detail(int stuNum, Model model){
        Score score = scoreService.getDetail(stuNum);
        model.addAttribute("detail", score);
        log.info("/score/detail GET : ");
        return "score/detail";
    }


}
