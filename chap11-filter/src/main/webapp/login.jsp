<%--
  Created by IntelliJ IDEA.
  User: 803-19
  Date: 2024-10-16
  Time: 오후 2:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>로그인</title>
</head>
<body>
    <h1>로그인 페이지</h1>
    <form action="login" method="post">
        <input type="text" name="userId" placeholder="User ID">
        <input type="password" name="password" placeholder="Password">
        <button type="submit">로그인</button>
    </form>
    <h3 style="color: red;">
        <%= request.getAttribute("loginError") != null ? request.getAttribute("loginError") : "" %>
    </h3>
    <a href="register.jsp">가입하기</a>
</body>
</html>

</html>
