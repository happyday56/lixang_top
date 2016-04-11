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
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/m.css" />"/>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery1.7.2.js" />"></script>
    <script type="text/javascript">
        $(function () {
            $(".left a").click(function () {
                $(".left a").removeClass("current");
                $(this).addClass("current");
            });

            $(window).resize(function () {
                resize();
            });

            resize();
        });

        function resize() {
            var w = $(window).width() - $(".left").width();
            //var h = $(window).height() - $(".bot").height();
            $(".right").width(w);
            $(".right").height(500);
            $(".rightbody").height(500);

        }

    </script>

</head>
<body>
<div id="box">
    <div style="background: #00a2ca; height: 5px;"></div>
    <h1>管理后台</h1>

    <div style="clear: both;"></div>
    <div class="mid">
        <div class="left">
            <div class="leftbody">
                <dl>
                    <dt>网站栏目</dt>
                    <dd>
                        <div><a href="<c:url value="/man/bloglist" />" target="frmRight" class="current">文章</a></div>

                    </dd>
                </dl>

            </div>
        </div>
        <div class="right">
            <div class="rightbody">
                <iframe id="frmRight" name="frmRight" src="<c:url value="/man/bloglist" />" frameborder="0" scrolling="auto"
                        width="100%" height="100%"></iframe>
            </div>
        </div>
        <div style="clear: both;"></div>
    </div>
    <div style="clear: both;"></div>
    <div class="bot">
        @WebConfig.CopyRight
    </div>
</div>
</body>
</html>
