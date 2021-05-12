<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title></title>
<style>
    div{
        display: flex;
        justify-content: center;
        align-content: center;
        border : 3px solid orange;
        border-radius: 10px;
        width: 600px;
        height: 500px;
    }
    li{
        text-decoration: none;
    }
</style>
</head>
<body>

    <div>

        <ul>
            <h1>${detail.name}님의 성적 정보</h1>
            <li># 국어 : ${detail.kor} 점</li>
            <li># 영어 : ${detail.eng} 점</li>
            <li># 수학 : ${detail.math} 점</li>
            <li># 총점 : ${detail.total} 점</li>
            <li># 평균 : ${detail.average} 점</li>
        </ul>
        
        <a href="/score/list">목록</a>
    </div>

</body>
</html>