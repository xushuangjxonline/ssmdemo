<%--
  Created by IntelliJ IDEA.
  User: doublemono
  Date: 2019/10/6
  Time: 0:02
  To change this template use File | Settings | File Templates.
--%>
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
<form action="staff/doAdd" method="post" id="form">
    <div>员工姓名:<input type="text" name="staffname" id="staffname" ></div>
    <div>员工性别:<input type="text" name="gender" id="gender"></div>
    <div>电子邮箱:<input type="text" name="email" id="email"></div>
    <div>上传头像:<input type="text" name="photo" id="photo"></div>
    <div>员工工资:<input type="text" name="salary" id="salary"></div>
</form>
    <div>所属部门:
        <label><input name="did" type="checkbox" value="1" />市场部 </label>
        <label><input name="did" type="checkbox" value="2" />开发部 </label>
        <label><input name="did" type="checkbox" value="3" />运维部 </label>
        <label><input name="did" type="checkbox" value="4" />运行部 </label>
        <label><input name="did" type="checkbox" value="5" />客服部 </label>
        <label><input name="did" type="checkbox" value="6" />人力部 </label>
    </div>

    <div>
        <input type="button"  id="submit" value="提交" >
        <input type="button" value="返回" onclick="returnback();">
    </div>


</body>
<script type="text/javascript">

    function returnback(){
        window.location.href="staff/list"
    }

    $(document).ready(function () {
        $("#submit").click(function () {
            var checkId = new Array;
            $('input[name="did"]:checked').each(function () {
                checkId.push($(this).val());
            });

            var arry = $("#form").serializeArray();
            var obj = new Object();
            for (var i = 0; i < arry.length; i++) {
                obj[arry[i].name] = arry[i]['value'];
            }

            /*var jsonData =[checkId,obj];*/
            var jsonData = [{"checkId":checkId},{"staffModel" : obj}];
            console.log(JSON.stringify(jsonData));


           jQuery.ajaxSettings.traditional = true;

            $.ajax({
                url: "staff/doAdd",
                contentType:"application/json;charset=utf-8",
                data: JSON.stringify(jsonData),
                dateType:'json',
                type:"POST",
                async:"false",
                success: function () {
                    alert("success");
                }
            })


/*            var staffArray = new Array();
            var staffname = $("#staffname").val();
            var gender = $("#gender").val();
            var email = $("#email").val();
            var photo = $("#photo").val();
            var salary = $("#salary").val();
            staffArray.push(staffModel:[{staffname:"staffname"},])
            alert(staffname);
            alert(checkId);*/
/*            $.ajax({
                url:"staff/doAdd",
                type:"POST"
            })*/
/*                var url = " staff/doAdd";
                var param = {checkId:checkId};
                //阻止深度序列化，防止在后台获取不到数据
                jQuery.ajaxSettings.traditional = true;
                alert(checkId);
/!*                if(confirm("你确定删除吗？" + checkId)){
                    $.post(url,param,function (data) {
                        window.location.reload(true);
                    },"html")
                }*!/*/
        })

    })
</script>
</html>

