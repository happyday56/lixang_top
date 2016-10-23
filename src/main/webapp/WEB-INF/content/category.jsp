<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!doctype html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, minimal-ui"/>

    <meta name="keywords" content="${list.category.keywords }"/>
    <meta name="description" content="${list.category.description }"/>
    <meta name="author" content="nice98"/>
    <meta name="copyright" content="nice98版权所有"/>
    <title>${list.nav.title}</title>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" type="text/css"/>
    <link href="<c:url value="/resources/css/pagebar.css" />" rel="stylesheet" type="text/css"/>
    <link rel="shortcut icon" href="<c:url value="/resources/images/favicon.ico"/>" type="image/x-icon"/>
</head>

<body>
<div id="wrapper">

    <c:import url="top.jsp"></c:import>

    <div id="content">
        <div style="margin-top: 10px;">
            当前位置：<a href="<c:url value="http://nice98.com"/>">首页</a> &raquo; <a
                href="<c:url value="${list.nav.url}"/>">${list.nav.title}</a>
        </div>

        <c:forEach items="${list.blogs}" var="item" begin="0" end="10" varStatus="status">
            <div class="list">
                <div class="list_title">
                    <a href="<c:url value="/v/${item.id}" />"
                       title="${item.title }"><h1>${item.title }</h1></a>
                </div>
                <div class="list_summary">
                    <a href="<c:url value="/v/${item.id}" />">
                        <c:if test="${item.pictureUrl!=''}">
                            <div class="list_img_holder"><img src="${item.pictureUrl}"/></div>
                        </c:if>
                        <label><fmt:formatDate value="${item.uploadTime }"
                                               pattern="yyyy年M月d日"/></label> ${item.summary }
                    </a></div>
                <div class="clear"></div>
            </div>
        </c:forEach>

        <div class="pagebar">
            ${list.pagebar}
        </div>
    </div>
    <c:import url="left.jsp"></c:import>


    <c:import url="bot.jsp"></c:import>

</div>
</body>
</html>
