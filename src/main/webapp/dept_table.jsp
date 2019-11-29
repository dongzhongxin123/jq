<%@page pageEncoding="UTF-8" isELIgnored="false" language="java" contentType="text/html; UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="app" value="${pageContext.request.contextPath}"></c:set>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>员工列表</title>
    <!--bootStrap的核心css-->
    <link rel="stylesheet" href="${app}/boot/css/bootstrap.min.css">
    <link rel="stylesheet" href="${app}/statics/jqgrid/css/trirand/ui.jqgrid-bootstrap.css">

    <script src="${app}/statics/boot/js/jquery-3.3.1.min.js"></script>
    <script src="${app}/statics/boot/js/bootstrap.min.js"></script>
    <script src="${app}/statics/jqgrid/js/trirand/i18n/grid.locale-cn.js"></script>
    <script src="${app}/statics/jqgrid/js/trirand/jquery.jqGrid.min.js"></script>

    <script>

        //懒函数加载
        $(function () {

            $("#tb").jqGrid({
                //通过分页查看所有
                url: "${app}/dept/queryAllDeptByPage",
                styleUI: 'Bootstrap',  //设置bootstrap的样式
                datatype: "json",  //以json形式返回
                mtype: "post",     //请求方式
                pager: "#page",    //显示分页
                viewrecords: true, //显示总条数
                rowList: [2, 4, 6, 8],  //设置每页的条数
                colNames: ["编号", "名称", "操作"],
                autowidth: true,   //宽度自适应
                editurl: "${app}/dept/edit",
                colModel: [
                    {
                        name: "id",
                        editable: true,
                    },
                    {
                        name: "name",
                        editable: true,
                    },
                    {
                        formatter: function (cellvalue, options, rowobject) {
                            return "<a href=\"javascript:edit('" + rowobject.id + "')\" class=\"btn btn-warning\" id=\"edit\"><span class=\"glyphicon glyphicon-pencil\"></span>修改</a> <a href=\"javascript:del('" + rowobject.id + "')\" class=\"btn btn-danger\" id=\"delete\"><span class=\"glyphicon glyphicon-trash\"></span>删除</a>\n";
                        }
                    }
                ],
                toolbar: ['true', 'top'],
                caption: "部门管理V3.0",
            }).jqGrid("navGrid", "#page");

            $("#t_tb").append("<a href=\"javascript:add()\" class=\"btn btn-info\" id=\"add\"><span class=\"glyphicon glyphicon-plus\"></span>添加</a>");
        })

        //修改
        function edit(gr) {
            if (gr != null)
                $("#tb").jqGrid('editGridRow', gr, {
                    height: 300,
                    reloadAfterSubmit: true
                });
            else
                alert("Please Select Row");
        }

        //删
        function del(gr) {
            if (gr != null)
                $("#tb").jqGrid('delGridRow', gr, {
                    reloadAfterSubmit: true
                });
            else
                alert("Please Select Row to delete!");
        }

        //添加
        function add() {
            jQuery("#tb").jqGrid('editGridRow', "new", {
                height: 300,
                reloadAfterSubmit: true
            });
        }
    </script>
</head>
<body>
<table id="tb"></table>
<div id="page"></div>
</body>
</html>
