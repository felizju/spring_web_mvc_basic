package com.spring.mvc.web.score.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.ResultSet;
import java.sql.SQLException;

@Getter @Setter
@ToString
public class Score {

    // 순차적인 학번 부여 필드
    private static int sequence;
    
    private int stuNum; // 학번
    private String name; // 이름
    private int kor;
    private int eng;
    private int math;
    private int total; // 총점
    private double average; // 평균

    public Score(){
        this.stuNum = ++sequence;
    }

    public Score(String name, int kor, int eng, int math) {
        this(); // this.stuNum = ++sequence;
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    public Score(ResultSet rs) throws SQLException {
        this.stuNum = rs.getInt("stu_num");
        this.name = rs.getString("stu_name");
        this.kor = rs.getInt("kor");
        this.eng = rs.getInt("eng");
        this.math = rs.getInt("math");
        this.total = rs.getInt("total");
        this.average = rs.getDouble("average");
    }

    // 총점, 평균을 구하는 메서드
    public void calcTotalAvg(){
        this.total = kor+eng+math;
        this.average = Math.round((this.total / 3.0) * 100) / 100.0;
    }

}
