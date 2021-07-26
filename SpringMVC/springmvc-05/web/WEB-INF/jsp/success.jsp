<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
<h1>登录成功页面</h1>
<hr>
${sessionScope.user}
<a href="${pageContext.request.contextPath}/user/logout">注销</a>
</body>
</html>
