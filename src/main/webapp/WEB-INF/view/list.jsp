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

    <title>登陆成功</title>
    <body>
        <div>
            <table >
                <tr>
                    <td align="center"><input type="checkbox" id="checkAll">全选/全不选</td>
                    <td align="center">管理员id</td>
                    <td align="center">管理员账号</td>
                    <td align="center">管理员密码</td>
                    <td align="center">查看权限</td>
                    <td align="center">超管权限</td>
                    <td align="center">操作</td>
                </tr>
            </table>
        </div>
        <div>
            <table >
        <C:forEach items="${userList}" var="userModel">
            <tr>
                <td align="center"><input type="checkbox" name="check" value="${userModel.uid}"></td>
                <td align="center">${userModel.uid}</td>
                <td align="center">${userModel.username}</td>
                <td align="center">${userModel.password}</td>
                <td align="center">${userModel.power}</td>
                <td align="center">${userModel.is_superAdmin}</td>
                <td align="center"> <input type="button" id="delete" value="删除" onclick="del(${userModel.uid});">
                                    <input type ="button" id="update" value="修改" onclick="update(${userModel.uid});">
 <%--                                   <input type="button" id="view" value="查看详细" onclick="view(${userModel.uid});">--%>

                </td>
            </tr>
        </C:forEach>
            </table>
        </div>
    <div>

        <div><input type="button"  id="del" value="删除选中" >
             <input type="button"  id="add" value="添加管理员" onclick="add();">
        </div>
    </div>
    </body>


    <script type="text/javascript">

        //全选反选按钮功能
        $("#checkAll").click(function () {
            if ($(this).is(":checked")) {
                $("[name=check]:checkbox").prop("checked", true);
            } else {
                $("[name=check]:checkbox").prop("checked", false);
            }
        });


        //checkbox删除功能
        $(document).ready(function () {
            $("#del").click(function () {
                var checkId = new Array;
                $('input[name="check"]:checked').each(function () {
                    checkId.push($(this).val());
                });
                if (checkId.length <= 0) {
                    alert("请选择要删除的数据！");
                } else {
                    var url = " user/doDel";
                    var param = {checkId:checkId};
                    //阻止深度序列化，防止在后台获取不到数据
                    jQuery.ajaxSettings.traditional = true;
                    if(confirm("你确定删除吗？" + checkId)){
                        $.post(url,param,function (data) {
                            window.location.reload(true);
                        },"html")
                    }
                }
            })

        })

        //删除单条数据的方法
        function del(para){
            var param = {id :para};
            var url = "user/doDelete";
            if(confirm("你确定删除吗？" + para)){
                $.post(url,param,function (data) {
                    window.location.reload(true);
                },"html")
            }
        }

        //TODO 修改的方法
        function update(para) {
                window.location.href="user/update/"+para;
        }

/*        //TODO 查看详细页面的方法
        function view(para) {
            window.location.href="user/view/"+para;
        }*/

        //跳转添加页面的方法
        function add(){
            window.location.href="user/add";
        }


    </script>
</html>
