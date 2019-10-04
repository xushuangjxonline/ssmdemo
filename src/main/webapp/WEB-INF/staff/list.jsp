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

<title>员工页面</title>
<body>
   <div class="container" id="pagingList">
       <table style="width: 900px;" class="table table-striped table-hover table-bordered">
           <div><input type="button"  id="del" value="删除选中" >
               <input type="button"  id="add" value="添加管理员" onclick="add();">
           </div>
           <thead>
           <tr>
               <th><input type="checkbox" id="checkAll">全选/全不选</th>
               <th>员工编号</th>
               <th>员工姓名</th>
               <th>员工性别</th>
               <th>电子邮箱</th>
               <th>员工工资</th>
               <th>所属部门</th>
               <th>操作</th>
           </tr>
           </thead>
           <tbody>
        <C:forEach items="${list}" var="staffList">
           <tr>
               <td><input type="checkbox" name="check" value="${staffList.sid}"></td>
               <td>${staffList.sid}</td>
               <td>${staffList.staffname}</td>
               <td>${staffList.gender}</td>
               <td>${staffList.email}</td>
               <td>${staffList.salary}</td>
            <td>
            <C:forEach items="${staffList.staffDepartmentMappingModelList}" var="mappingList">
                <C:if test="${mappingList.departmentid == 1}">市场部</C:if>
                <C:if test="${mappingList.departmentid == 2}">开发部</C:if>
                <C:if test="${mappingList.departmentid == 3}">运维部</C:if>
                <C:if test="${mappingList.departmentid == 4}">运营部</C:if>
                <C:if test="${mappingList.departmentid == 5}">客服部</C:if>
                <C:if test="${mappingList.departmentid == 6}">人力部</C:if>
            </C:forEach>
            </td>
               <td><input type="button" id="delete" value="删除" onclick="del(${staffList.sid});">
                   <input type ="button" id="update" value="修改" onclick="update(${staffList.sid});">
               </td>
         </C:forEach>
           </tr>
           </tbody>
       </table>
       <div>
           共有${pageBean.totalRecord}条数据,${pageBean.totalPage}页 <br/> <input
               type="button" name="page" id="page" value="首页"
               onclick="getPagingList(1);">

           <C:if test="${pageBean.pageNum > 1}">
               <input type="button" name="page" id="page" value="上一页"
                      onclick="getPagingList(${pageBean.pageNum-1});">
           </C:if>
           <C:choose>
               <C:when test="${pageBean.totalPage <= 5 }">
                   <C:set var="begin" value="1"/>
                   <C:set var="end" value="${pageBean.totalPage}"/>
               </C:when>
               <C:otherwise>
                   <C:set var="begin" value="${pageBean.pageNum-2}"/>
                   <C:set var="end" value="${pageBean.pageNum+2}"/>
                   <C:if test="${begin < 1 }">
                       <C:set var="begin" value="1"/>
                       <C:set var="end" value="5"/>
                   </C:if>
                   <C:if test="${end > pageBean.totalPage }">
                       <C:set var="begin" value="${pageBean.totalPage - 2 }" />
                       <C:set var="end" value="${pageBean.totalPage }" />
                   </C:if>
               </C:otherwise>
           </C:choose>
           <C:forEach var="i" begin="${begin }" end="${end }">
               <C:choose>
                   <C:when test="${i eq pageBean.pageNum }">
                       <input type="button" name="page" id="page" value="${i }"
                              onclick="getPagingList(${i });">
                   </C:when>
                   <C:otherwise>
                       <input type="button" name="page" id="page" value="${i }"
                              onclick="getPagingList(${i });">
                   </C:otherwise>
               </C:choose>
           </C:forEach>
           <C:if test="${pageBean.pageNum  < pageBean.totalPage }">
               <input type="button" name="page" id="page" value="下一页"
                      onclick="getPagingList(${pageBean.pageNum+1 });">
           </C:if>


           <input type="button" name="page" id="page" value="尾页"
                  onclick="getPagingList(${pageBean.totalPage});">

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
                var url = " staff/doDel";
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
        var url = "staff/doDelete";
        if(confirm("你确定删除吗？" + para)){
            $.post(url,param,function (data) {
                window.location.reload(true);
            },"html")
        }
    }

    //修改的方法
    function update(para) {
        window.location.href="staff/update/"+para;
    }


    //跳转添加页面的方法
    function add(){
        window.location.href="staff/add";
    }

    //分页的方法
    function getPagingList(param){
        var para = {pageNum :param};
        var url = "<%=basePath%>staff/pagingList";
        $.get(url,para,function(data){
            $("#pagingList").html(data);
        },"html");
    }


</script>
</html>
