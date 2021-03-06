<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main.css" />"/>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery1.7.2.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.utils.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/paging.js" />"></script>
    <script type="text/javascript">
        var request = {
            type: 0,
            current: 1,
            length: 5,
            key: "",
            isContentNull: 0
        };

        $(function () {
            LoadList();

            //搜索
            $("#btnSearch").click(function () {
                var searchContent = $("#key").val();
                request.key = searchContent;
                request.isContentNull = $("#isContentNull").attr("checked") ? 1 : 0;
                LoadList();
            });

        });

        function LoadList() {

            J.AjaxJsonPost("bloglist.do", JSON.stringify(request),
                    function (data) {
                        if (data != null) {
                            var list = data.list;
                            var page = data.page;
                            html = "";

                            for (var i = 0; i < list.length; i++) {
                                var row = list[i];
                                html += '<tr><td>' + row.id + '</td>'
                                        + '<td><a href="../v/' + row.id + '" target="_blank">' + row.title + '</a></td>'
                                        + '<td>' + row.categoryTitle + '</td>'
                                        + '<td>' + (row. pictureUrl!=""?"有图":"") + '</td>'
                                        + '<td>' + row.keywords + '</td>'
                                        + '<td>' + row.description + '</td>'
                                        + '<td>' + J.UtcToDateString(row.uploadTime) + '</td>'
                                        + '<td>' + row.views + '</td>'
                                        + '<td><a href="blogedit?id=' + row.id + '&oper=edit"  target="_blank">修改</a></td></tr>';
                            }

                            $("#tbList").find("tbody").html(html);

                            LoadPaging($(".pagination"), page.current, page.length, page.count);
                        }
                        else {
//                            alert(data.resultDescription);
                        }
                    });
        }


    </script>
</head>
<body>

<div id="Search">


    <label class="" for="key">标题</label>
    <input id="key" name="key" class="txt" type="text" style="width: 125px;" value=""/>
    <input id="isContentNull" type="checkbox"/>内容为空
    <input class="button1" type="submit" id="btnSearch" value="搜索"/>

    <a style="float:right;" href="blogedit?oper=add">添加>></a>
</div>


<table width="100%" id="tbList">
    <thead>
    <tr>
        <th style="width: 80px">序号</th>
        <th>标题</th>
        <th>分类</th>
        <th>图片</th>
        <th>关键字</th>
        <th>描述</th>
        <th>上传时间</th>
        <th>浏览次数</th>
        <th style="width: 50px">操作</th>
    </tr>
    </thead>
    <tbody>

    </tbody>
</table>

<ul class="pagination" style="margin-top: 10px;">
</ul>


<!-- Right Side/Main Content End -->


</body>
</html>
