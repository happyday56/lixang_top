<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, minimal-ui"/>

    <meta name="keywords" content="友情链接"/>
    <meta name="description" content="友情链接"/>
    <meta name="author" content="nice98"/>
    <meta name="copyright" content="nice98版权所有"/>
    <title>友情链接</title>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" type="text/css"/>
    <link rel="shortcut icon" href="<c:url value="/resources/images/favicon.ico"/>" type="image/x-icon"/>
</head>

<body>
<div id="wrapper">

    <c:import url="top.jsp"></c:import>

    <div id="content">
        <div>
            <div>
                <h1><a href="">友情链接</a></h1>
            </div>

            <p><span style="color: #808080;">&nbsp;</span></p>

            <p style="padding-left: 20px;"><span style="color: #808080;"><a style="color: #808080;"
                                                                            href="http://www.cnblogs.com/"
                                                                            target="_blank">博客园</a></span></p>
        </div>


    </div>

    <c:import url="left.jsp"></c:import>
    <c:import url="bot.jsp"></c:import>

</div>
</body>
</html>
