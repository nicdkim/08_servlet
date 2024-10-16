<%--
  Created by IntelliJ IDEA.
  User: 803-19
  Date: 2024-10-16
  Time: 오후 2:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>메인 페이지</title>
</head>
<body>
    <h1>환영합니다! <%= session.getAttribute("userId") %>님!</h1>
    <a href="logout">로그아웃</a>
</body>
</html>

</html>
