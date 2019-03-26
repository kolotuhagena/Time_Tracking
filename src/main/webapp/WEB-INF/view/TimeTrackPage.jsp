<%--
  Created by IntelliJ IDEA.
  User: WK
  Date: 3/22/2019
  Time: 5:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<fmt:setBundle basename="language"/>
<fmt:message key="title" var="title"/>
<fmt:message key="main.button" var="button"/>
<fmt:message key="main.add" var="add"/>
<fmt:message key="main.delete" var="delete"/>

<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="styles/style.css">
    <title>${title}</title>
</head>
<body>
<jsp:include page="Components/header.jsp"/>
<table>
    <th><fmt:message key="main.track_id"/> </th>
    <th><fmt:message key="main.activity_name"/></th>
    <th><fmt:message key="main.active"/></th>
    <th><fmt:message key="main.completed"/></th>
    <th><fmt:message key="main.time"/></th>
    <caption><fmt:message key="main.table_name"/></caption>
    <c:forEach items="${sessionScope.trackList}" var="trackList">
        <tr>
            <td><c:out value="${trackList.trackID}"/></td>
            <td><c:out value="${trackList.activity.name}"/></td>
            <td><c:out value="${trackList.isActive()}"/></td>
            <td><c:out value="${trackList.isCompleted()}"/></td>
            <td><c:out value="${trackList.elapsedTime.getTime()}"/></td>
        </tr>
    </c:forEach>
</table>
<div class="col md-12 col lg-12 d-flex justify-content-center">
    <div class="paginationCenter">
        <div class="pagination">
            <c:if test="${currentPage != 1 }">
                <a href="${pageContext.request.contextPath}/home?page=${currentPage - 1}">&laquo;</a>
            </c:if>
            <c:forEach begin="1" end="${noOfPages}" var="i">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        <a href="" class="active">${i}</a>
                    </c:when>
                    <c:otherwise>
                        <a href="${pageContext.request.contextPath}/home?page=${i}">${i}</a>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <c:if test="${currentPage lt noOfPages}">
                <a href="${pageContext.request.contextPath}/home?page=${currentPage + 1}">&raquo;</a>
            </c:if>
        </div>
    </div>
</div>

<h3><fmt:message key="main.update_name_form"/> </h3>
<form action="?act=update" method="post">
    <select required name="number" type="number">
        <c:forEach items="${sessionScope.trackList}" var="trackList">
            <option value="${trackList.trackID}"><c:out value="${trackList.trackID}"/></option>
        </c:forEach>
    </select>
    <input required name="time" type="text"/>
    <input value="${button}" type="submit"/>
</form>

<h3><fmt:message key="main.add_name_form"/> </h3>
<form action="?act=add" method="post">
    <select required name="activity" type="number">
        <c:forEach items="${sessionScope.activityList}" var="activityList">
            <option value="${activityList.activityId}"><c:out value="${activityList.name}"/></option>
        </c:forEach>
    </select>
    <input value="${add}" type="submit"/>
</form>
<h3><fmt:message key="main.delete_name_form"/></h3>
<form action="?act=delete" method="post">
    <select required name="number" type="number">
        <c:forEach items="${sessionScope.trackList}" var="trackList">
            <option value="${trackList.trackID}"><c:out value="${trackList.trackID}"/></option>
        </c:forEach>
    </select>
    <input value="${delete}" type="submit"/>
</form>
</body>
</html>