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

</style>
</head>
<body>
    <h1>${board.boardNum}번 게시물 내용</h1>
    <p>
        # 글 번호 : ${board.boardNum} <br>
        # 작성자 : ${board.name} <br>
        # 제목 : ${board.title} <br>
        # 내용 : ${board.content} <br>
    </p>
    <a href="/board/list">글 목록보기</a><br>
    <a href="/board/modify?boardNum=${board.boardNum}">글 수정하기</a>
</body>
</html>