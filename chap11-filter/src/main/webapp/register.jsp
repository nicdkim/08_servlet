<%--
  Created by IntelliJ IDEA.
  User: 803-19
  Date: 2024-10-16
  Time: 오후 2:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>회원가입</title>
</head>
<body>
    <h1>회원가입</h1>
    <form action="register" method="post">
        <input type="text" name="userId" placeholder="User ID">
        <input type="password" name="password" placeholder="Password">
        <input type="email" name="email" placeholder="Email">
        <button type="submit">가입하기</button>
    </form>
    <a href="login.jsp">로그인 화면</a>
</body>
</html>

</html>
