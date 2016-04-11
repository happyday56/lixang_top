<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, minimal-ui"/>
    <meta name="keywords" content="nice98 综合门户 移动互联网新闻 健康新闻 电子商务新闻 游戏新闻"/>
    <meta name="description" content="中国的web2.0综合门户网站。提供互联网、医疗健康行业资讯、数据分析报告等服务。是中国互联网从业人士交流最权威的平台，是了解中国互联网行业最重要的窗口。"/>
    <meta name="author" content="nice98"/>
    <meta name="copyright" content="nice98版权所有"/>
    <title>nice98--分享知识，把握未来</title>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" type="text/css"/>
    <link href="<c:url value="/resources/css/pagebar.css" />" rel="stylesheet" type="text/css"/>
    <link rel="shortcut icon" href="<c:url value="/resources/images/favicon.ico"/>" type="image/x-icon"/>

</head>

<body>

<div id="wrapper">

    <c:import url="top.jsp"></c:import>


    <div id="content">
        <c:forEach items="${list.blogs}" var="item" begin="0" end="10" varStatus="status">
            <div class="list">
                <div class="list_title">
                    <a href="<c:url value="http://nice98.com/v/${item.id}" />"
                       title="${item.title }"><h1>${item.title }</h1></a>
                </div>
                <div class="list_summary">
                    <a href="<c:url value="http://nice98.com/v/${item.id}" />">
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
