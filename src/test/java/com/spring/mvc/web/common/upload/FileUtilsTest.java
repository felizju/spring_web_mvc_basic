package com.spring.mvc.web.common.upload;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FileUtilsTest {

    @Test
    void uuidTest(){

        String fileName = "dog.jpg";
        String newFileName = UUID.randomUUID().toString() + "_" + fileName; // 랜덤 파일명 생성해줌
        System.out.println("newFileName = " + newFileName);

    }

}