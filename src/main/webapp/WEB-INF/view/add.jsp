<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <link href="css/bootstrap.css" rel="stylesheet">
    <script src="js/bootstrap.js"></script>
<head>
    <title>老子是添加页面</title>
</head>
<body>
<form action="user/doAdd" method="post">
    <div>管理员账号:<input type="text" name="username" id="username" ></div>
    <div>管理员密码:<input type="text" name="password" id="password"></div>
    <div>管理员权限:<input type="text" name="power" id="power"></div>
    <div>超管权限:<input type="text" name="is_superAdmin" id="is_superAdmin"></div>

    <div>
        <input type="submit" value="提交" >
        <input type="button" value="返回" onclick="returnback();">
    </div>

</form>
</body>
    <script type="text/javascript">

        function returnback(){
            window.location.href="user/list"
        }
    </script>
</html>
