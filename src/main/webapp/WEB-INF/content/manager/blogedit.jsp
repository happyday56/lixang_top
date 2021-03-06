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
    <script charset="utf-8" src="<c:url value="/resources/js/kindeditor/kindeditor.js" />"
            type="text/javascript"></script>
    <script charset="utf-8" src="<c:url value="/resources/js/kindeditor/lang/zh_CN.js" />"
            type="text/javascript"></script>

    <script src="<c:url value="/resources/js/My97DatePicker/WdatePicker.js" />" type="text/javascript"></script>

    <script type="text/javascript">
        var id = J.getQueryString("id");
        var oper = J.getQueryString("oper");
        var model = {};

        $(function () {
            if (oper == "edit") {
                J.AjaxJsonPost("blogedit.do?id=" + id, "",
                        function (data) {
                            $("#id").html(data.id);
                            $("#title").val(data.title);
                            $("#category").val(data.categoryId);
                            editor.html(data.content);
                            $("#summary").val(data.summary);
                            $("#keywords").val(data.keywords);
                            $("#description").val(data.description);
                            $("#uploadTime").val(J.UtcToDateString(data.uploadTime));
                            $("#views").val(data.views);
                            $("#pictureUrl").val(data.pictureUrl);
                            $("#imgPictureUrl").attr("src", data.pictureUrl);
                            initCategory(data.categories, data.categoryId);
                        });
            }
            else {
                J.AjaxJsonPost("blogedit.do", "",
                        function (data) {
                            initCategory(data, 0);
                        });
            }

            $("#btnSave").click(function () {
                model.operType = oper;
                model.id = $("#id").html();
                if (model.id == "") model.id = "0";
                model.title = $("#title").val();
                model.categoryId = $("#category").val();
                model.content = $.trim(editor.html());
                model.summary = $("#summary").val();
                model.keywords = $("#keywords").val();
                model.description = $("#description").val();
                model.uploadTime = J.StringToDate($("#uploadTime").val());
                model.views = $("#views").val();
                model.pictureUrl = $("#pictureUrl").val();
                J.AjaxJsonPost("blogedit.save", JSON.stringify(model),
                        function (data) {
                            if (data == 1) {
                                alert("保存成功");
                                window.location = "bloglist";
                            } else {
                                alert(data);
                            }
                        });
            });
        });

        function initCategory(list, id) {
            var html = "";
            for (var i = 0; i < list.length; i++) {
                html += '<option value="' + list[i].id + '" ' + (id == list[i].id ? 'selected="selected"' : '') + '>' + list[i].title + '</option>';
            }
            $("#category").html(html);
        }
    </script>
</head>
<body>


<table width="100%">
    <tr>
        <th>序号</th>
        <td><span id="id"></span></td>
    </tr>
    <tr>
        <th>标题</th>
        <td><input id="title" type="text" size="100"/></td>
    </tr>
    <tr>
        <th>分类</th>
        <td>
            <select id="category">

            </select>
        </td>
    </tr>
    <tr>
        <th>内容</th>
        <td><textarea id="content"></textarea></td>
    </tr>
    <tr>
        <th>摘要</th>
        <td><input id="summary" type="text" size="100"/></td>
    </tr>
    <tr>
        <th>图片地址</th>
        <td><img id="imgPictureUrl" src="" alt="" width="200px" height="auto"/>
            <br/>
            <input id="pictureUrl" type="text" size="100"/>

        </td>
    </tr>

    <tr>
        <th>关键字</th>
        <td><input id="keywords" type="text" size="100"/></td>
    </tr>
    <tr>
        <th>描述</th>
        <td><input id="description" type="text" size="100"/></td>
    </tr>

    <tr>
        <th>上传时间</th>
        <td><input id="uploadTime" type="text" size="100"
                   onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false,readOnly:true})"/></td>
    </tr>
    <tr>
        <th>浏览次数</th>
        <td><input id="views" type="text" size="100"/></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="button" id="btnSave" value="保存"/>

        </td>
    </tr>
</table>


<script type="text/javascript">
    KindEditor.ready(function (K) {
        window.editor = K.create('#content', {
            width: '700px'
            , height: '200px'
            , uploadJson: '../file/uploadUeImage'
            , items: [
                'source', 'undo', 'redo', '|', 'preview', 'cut', 'copy', 'paste',
                'plainpaste', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright',
                'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript',
                'superscript', 'clearhtml', 'quickformat', 'selectall', '|', 'fullscreen', '/',
                'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold',
                'italic', 'underline', 'strikethrough', 'lineheight', 'removeformat', '|', 'multiimage',
                'table', 'hr', 'emoticons', 'pagebreak',
                'anchor', 'link', 'unlink'
            ]
        });
    });
</script>
</body>
</html>
