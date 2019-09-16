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

<body>
<h2>Hello World!</h2>
<button type="button" class="btn btn-success">（成功）Success</button>
</body>
</html>
