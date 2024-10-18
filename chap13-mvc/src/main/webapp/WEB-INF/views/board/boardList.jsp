<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시판 목록</title>
    <style>
        body {
            margin: 20px;
            background-color: #f4f4f4;
        }
        h2 {
            color: #333;
        }
        a {
            color: #3498db;
            text-decoration: none;
            font-weight: bold;
        }
        a:hover {
            text-decoration: underline;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
            background-color: #fff;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 12px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
        button {
            background-color: #e74c3c;
            color: white;
            border: none;
            padding: 8px 8px;
            cursor: pointer;
            font-size: 14px;
            border-radius: 5px;
        }
        button:hover {
            background-color: #c0392b;
        }
        .btn-update {
            background-color: #3498db;
            color: white;
            padding: 8px 8px;
            text-decoration: none;
            border-radius: 5px;
            font-size: 14px;
        }

        .pagination {
            display: flex;
            justify-content: center;
            margin-top: 20px;
        }
        .pagination a, .pagination span {
            padding: 10px 15px;
            margin: 0 5px;
            border: 1px solid #ddd;
            border-radius: 5px;
            text-decoration: none;
            color: #3498db;
        }
        .pagination a {
            background-color: white;
        }
        .pagination span {
            background-color: #3498db;
            color: white;
        }
        .pagination a:hover {
            background-color: #ddd;
        }
    </style>
</head>
<body>

    <h2>게시판</h2>
    <a href="create" class="btn-primary">새 게시글 작성</a>

    <h2>게시글 목록</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일</th>
            <th>작업</th>
        </tr>
        <c:forEach var="board" items="${boardList}">
            <tr>
                <td>${board.boardId}</td>
                <td>
                    <a href="/board/detail?boardId=${board.boardId}">${board.title}</a>
                </td>
                <td>${board.empName}</td>
                <td>${board.createdAt}</td>
                <td>
                    <a href="/board/edit?boardId=${board.boardId}" class="btn-update">수정</a> |
                    <form action="/board/delete" method="post" style="display: inline">
                        <input type="hidden" name="boardId" value="${board.boardId}">
                        <button type="submit">삭제</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

    <div class="pagination">
        <c:forEach var="i" begin="1" end="${totalPages}">
            <c:choose>
                <c:when test="${i == currentPage}">
                    <span>${i}</span>
                </c:when>
                <c:otherwise>
                    <a href="list?page=${i}">${i}</a>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </div>
</body>
</html>
