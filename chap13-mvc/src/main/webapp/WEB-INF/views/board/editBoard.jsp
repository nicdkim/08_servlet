<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시글 수정</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f4f4f4;
        }
        h2 {
            color: #333;
            text-align: center;
        }
        form {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        label {
            font-size: 14px;
            color: #333;
            margin-bottom: 8px;
            display: block;
        }
        input[type="text"], textarea {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
            margin-bottom: 20px;
            font-size: 14px;
            box-sizing: border-box;
        }
        textarea {
            resize: vertical;
            height: 150px;
        }
        button {
            background-color: #3498db;
            color: white;
            border: none;
            padding: 12px 20px;
            font-size: 16px;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
            width: 100%;
        }
        button:hover {
            background-color: #2980b9;
        }
        a {
            display: block;
            text-align: center;
            margin-top: 20px;
            font-size: 14px;
            color: #3498db;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<h2>게시글 수정</h2>
<form action="edit" method="post">
    <input type="hidden" name="boardId" value="${board.boardId}">

    <label for="title">제목:</label>
    <input type="text" id="title" name="title" value="${board.title}" required><br>

    <label for="content">내용:</label>
    <textarea id="content" name="content" required>${board.content}</textarea><br>

    <button type="submit">수정하기</button>
</form>

<a href="list">돌아가기</a>

</body>
</html>
