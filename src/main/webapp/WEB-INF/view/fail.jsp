<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>登陆失败</title>


</head>
<base href="<%=basePath%>">

<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<link href="css/bootstrap.css" rel="stylesheet">
<script src="js/bootstrap.js"></script>
<script type="text/javascript">
    function countDown(){
        var time = $("#Time").html();
        //alert(time.innerHTML);
        //获取到id为time标签中的内容，现进行判断
        if(time == 0){
            //等于0时清除计时
            window.location.href="login/login_jumpLoginPage.action";
        }else{
            $("#Time").html(time-1)
        }
    }
    //1000毫秒调用一次
    window.setInterval("countDown()",1000);
</script>


<body>
<p>账号或密码错误</p>
<p><span id="Time">5</span><span>秒后自动跳转登陆页面</span></p>
<p><a href="user/welcome">点击跳转登陆页面</a></p>

</body>
</html>
