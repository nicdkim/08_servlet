<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Redirect</title>
    <script>
        function validateInput() {
            const titleInput = document.getElementById('title').value;
            const contentInput = document.getElementById('content').value;
            const errorMessage = document.getElementById('error-message');

            if (titleInput.length < 5) {
                errorMessage.textContent = "제목은 5자 이상이어야 합니다.";
            } else if (contentInput.length < 10) {
                errorMessage.textContent = "내용은 10자 이상이어야 합니다.";
            } else {
                errorMessage.textContent = "";
            }
        }
    </script>
</head>
<body>
    <h1>게시글 작성</h1>

    <h2 id="error-message" style="color: red"></h2>

    <form action="submitPost" method="post">
        제목: <input type="text" id="title" name="title"
                   oninput="validateInput()"><br><br>
        내용: <textarea type="text" id="content" name="content"
                      oninput="validateInput()"></textarea><br><br>
        <button type="submit">작성하기</button>
    </form>

    <p>==========================================================</p>
    <br/>
    <br/>
    <br/>
    <h1>redirect</h1>
    <br/>
    <ul>
        <li><a href="othersite">다른 웹 사이트로 redirect</a></li>
        <li><a href="otherservlet">다른 서블릿으로 redirect</a></li>
    </ul>
</body>
</html>