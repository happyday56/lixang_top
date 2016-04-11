<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div id="sidebar">
    <div class="section">
        <h3>Top</h3>
        <ul>
            <c:forEach items="${sidebar}" var="item" begin="0" end="10" varStatus="status">
                <li><a target="_blank"
                       href="<c:url value="http://nice98.com/v/${item.blog.id}" />"
                        > ${item.blog.title}</a>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>
