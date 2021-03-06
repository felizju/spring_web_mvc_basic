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
    <h1>${board.boardNum}번 게시글 내용 수정</h1>
    
    <form action="/board/modify" method="post">
        <input type="hidden" name="boardNum" value="${board.boardNum}">
        <input type="hidden" name="vf" value="false">
        <p>
            # 글번호 : ${board.boardNum}<br>
            # 작성자: <input type="text" name="writer" value="${board.writer}"><br>
            # 제목 : <input type="text" name="title" value="${board.title}"><br>
            # 내용 :
            <br>
            <textarea rows="5" cols="30" name="content">${board.content}</textarea>
        </p>
        <button type="submit">수정</button>
    </form>
    <br>
    <a href="/board/list">글 목록보기</a>
</body>
</html>