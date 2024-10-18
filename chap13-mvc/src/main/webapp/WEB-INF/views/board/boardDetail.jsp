<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시글 상세 보기</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f4f4f4;
        }
        h1 {
            color: #333;
            text-align: center;
            margin-bottom: 20px;
        }
        .content-container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        .content-item {
            margin-bottom: 15px;
            font-size: 16px;
        }
        .content-item span {
            font-weight: bold;
        }
        a {
            display: inline-block;
            margin-top: 20px;
            text-align: center;
            font-size: 14px;
            color: #3498db;
            text-decoration: none;
            background-color: #fff;
            padding: 10px 15px;
            border: 1px solid #3498db;
            border-radius: 5px;
            transition: background-color 0.3s, color 0.3s;
        }
        a:hover {
            background-color: #3498db;
            color: #fff;
        }
    </style>
</head>
<body>

<h1>게시글 상세 보기</h1>

<div class="content-container">
    <div class="content-item"><span>제목:</span> ${board.title}</div>
    <div class="content-item"><span>내용:</span> ${board.content}</div>
    <div class="content-item"><span>작성자:</span> ${board.empName}</div>
    <div class="content-item"><span>작성일:</span> ${board.createdAt}</div>

    <a href="list">돌아가기</a>
</div>

</body>
</html>
