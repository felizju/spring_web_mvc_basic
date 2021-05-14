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
        table {
            width: 500px;
            text-align: center;
        }
        h3{
            color : red;
        }
    </style>
</head>
<body>
    <c:if test="${boardList.size() <= 0}">
        <p>게시물이 존재하지 않습니다.</p>
    </c:if>

    <c:if test="${boardList.size() > 0}">

        <h1>게시글 목록</h1>
        <table border="1">
            <tbody>
                <tr>
                    <td>글번호</td>
                    <td>작성자</td>
                    <td>글제목</td>
                    <td>조회수</td>
                    <td>비고</td>
                </tr>

                <c:forEach var="board" items="${boardList}">
                    <tr>
                        <td>${board.boardNum}</td>
                        <td>${board.writer}</td>
                        <td><a href="/board/detail?boardNum=${board.boardNum}&vf=true">${board.title}</a></td>
                        <td>${board.viewCnt}</td>
                        <td><a href="/board/delete?boardNum=${board.boardNum}">삭제</a></td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>
    </c:if>

    <h3>## 총 게시물 수 : ${count}건</h3>
    <p>
        <a href="/board/write">게시글 작성하기</a>
    </p>
</body>
</html>