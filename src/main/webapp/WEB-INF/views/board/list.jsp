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
    table{
        width: 500px;
        text-align: center;
    }
</style>
</head>
<body>
    <h1>게시글 목록</h1>
    <table border="1">
        <tbody>
            <tr>
                <td>번호</td>
                <td>작성자</td>
                <td>제목</td>
                <td>비고</td>
            </tr>

            <c:forEach var="board" items="${boardList}">
                <tr>
                    <td>${board.boardNum}</td>
                    <td>${board.name}</td>
                    <td><a href="/board/detail?boardNum=${board.boardNum}">${board.title}</a></td>
                    <td><a href="/board/delete?boardNum=${board.boardNum}">삭제</a></td>
                </tr>
            </c:forEach>

        </tbody>
    </table>
    <p>
        <a href="/board/register">게시글 작성하기</a>
    </p>
</body>
</html>