<%--
  Created by IntelliJ IDEA.
  User: 803-19
  Date: 2024-10-18
  Time: 오전 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script>
    (function () {
        const successCode = '${requestScope.successCode}';
        let successMessage = "";
        let redirectUrl = "";

        switch (successCode) {
            case 'insertEmp' :
                successMessage = "신규 직원 등록 성공 !";
                redirectUrl = '${pageContext.servletContext.contextPath}/employee/list';
                break;
            case 'updateEmp' :
                successMessage = "직원 정보 수정 성공 !";
                redirectUrl = '${pageContext.servletContext.contextPath}/employee/list';
                break;
            case 'deleteEmp' :
                successMessage = "직원 정보 삭제 성공 !";
                redirectUrl = '${pageContext.servletContext.contextPath}/employee/list';
                break;
            case 'boardList' :
                successMessage = "게시글 불러오기 성공 !";
                redirectUrl = '${pageContext.servletContext.contextPath}/board/list';
                break;
            case 'insertBoard' :
                successMessage = "게시글 작성 성공 !";
                redirectUrl = '${pageContext.servletContext.contextPath}/board/list';
                break;
            case 'updateBoard' :
                successMessage = "게시글 수정 성공 !";
                redirectUrl = '${pageContext.servletContext.contextPath}/board/list';
                break;
            case 'deleteBoard' :
                successMessage = "게시글 삭제 성공 !";
                redirectUrl = '${pageContext.servletContext.contextPath}/board/list';
                break;
        }

        alert(successMessage);
        location.href = redirectUrl;
    })();
</script>
</body>
</html>
