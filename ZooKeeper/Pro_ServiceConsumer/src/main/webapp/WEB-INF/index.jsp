<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/index" method="post">
    <input type="text" name="id"><br>
    <input type="text" name="name"><br>
    <input type="submit"><br>

</form>
${requestScope.result}

</body>
</html>