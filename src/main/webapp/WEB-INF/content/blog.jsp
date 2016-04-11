<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!doctype html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, minimal-ui"/>

    <meta name="keywords" content="${item.keywords}"/>
    <meta name="description" content="${item.description}"/>
    <meta name="author" content="nice98"/>
    <meta name="copyright" content="nice98版权所有"/>
    <title>${item.title }_nice98</title>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" type="text/css"/>
    <link href="<c:url value="/resources/css/pagebar.css" />" rel="stylesheet" type="text/css"/>
    <link rel="shortcut icon" href="<c:url value="/resources/images/favicon.ico"/>" type="image/x-icon"/>
</head>

<body>
<div id="wrapper">

    <c:import url="top.jsp"></c:import>


    <div id="content">
        <div style="margin-top: 10px; padding-bottom: 20px;">
            当前位置：<a href="<c:url value="/"/>">首页</a> &raquo; <a
                href="<c:url value="${item.nav.url}"/>">${item.nav.title}</a>
        </div>

        <div class="item">
            <div class="item_title">
                <h1>${item.title }</h1>

                <p><fmt:formatDate value="${item.uploadTime }" pattern="yyyy年M月d日 H时m分"/></p>
            </div>
            <div class="item_content">
                ${item.content }
            </div>
            <br>

            <div id="item_share">
                <!-- JiaThis Button BEGIN -->
                <div class="jiathis_style">
                    <span class="jiathis_txt">订阅 | 分享：</span>
                    <a class="jiathis_button_qzone">QQ空间</a>
                    <a class="jiathis_button_tsina">新浪微博</a>
                    <a class="jiathis_button_tqq">腾讯微博</a>
                    <a class="jiathis_button_weixin">微信</a>
                    <a href="http://www.jiathis.com/share?uid=2047887"
                       class="jiathis jiathis_txt jiathis_separator jtico jtico_jiathis" target="_blank">更多</a>
                </div>
                <script type="text/javascript">
                    var jiathis_config = {data_track_clickback: 'true'};
                </script>
                <script type="text/javascript" src="http://v3.jiathis.com/code_mini/jia.js?uid=2047887"
                        charset="utf-8"></script>
                <!-- JiaThis Button END -->
            </div>

            <div class="clear"></div>


            <!-- todo 考虑获取出标题-->
            <div>
                <c:if test="${item.prevTitle!=null}">
                    <div>
                        上一篇→ <a href="<c:url value="/v/${item.id-1}"/>" rel="next">${item.prevTitle}</a>
                    </div>
                </c:if>
                <c:if test="${item.nextTitle!=null}">
                    <div>
                        下一篇→ <a href="<c:url value="/v/${item.id+1}"/>" rel=" prev">${item.nextTitle}</a>
                    </div>
                </c:if>
            </div>


        </div>


    </div>


    <c:import url="left.jsp"></c:import>

    <script src="/viewcount?id=${item.id}"></script>

    <c:import url="bot.jsp"></c:import>

</div>


</body>
</html>
