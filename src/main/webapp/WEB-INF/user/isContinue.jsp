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
    <title>添加完成</title>
</head>
<body>
    <div>
        <table>
            <tr>
                <th>管理员账号</th>
                <th>管理员密码</th>
                <th>管理员权限</th>
                <th>超管权限</th>
            </tr>
        </table>
        <table>
            <tr>
                <th>${userModel.username}</th>
                <th>${userModel.password}</th>
                <th>${userModel.power}</th>
                <th>${userModel.is_superAdmin}</th>
            </tr>
        </table>
    </div>
    <div>
        <input type="button" value="继续添加" onclick="add()">
        <input type="button" value="返回列表页" onclick="back()">
    </div>

</body>
    <script type="text/javascript" ></script>
    <script type="text/javascript">

        function back(){
            window.location.href="user/list"
        }

        function add(){
            window.location.href="user/add";
        }

    </script>
</html>
