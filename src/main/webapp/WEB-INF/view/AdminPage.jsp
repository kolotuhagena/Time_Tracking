<%--
  Created by IntelliJ IDEA.
  User: WK
  Date: 3/22/2019
  Time: 5:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<fmt:setBundle basename="language"/>
<fmt:message key="title" var="title"/>
<fmt:message key="admin.confirmAction" var="admin"/>

<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="styles/style.css">
    <title>${title}</title>
</head>
<body>
<!-- HEADER -->
<jsp:include page="/WEB-INF/view/Components/header.jsp"/>
<!-- /HEADER -->
<form method="post" action="${pageContext.request.contextPath}/administrate?act=true">
<div class="first-table">
<table>
    <th><fmt:message key="admin.table_id_col_name"/> </th>
    <th><fmt:message key="admin.table_type_col_name"/></th>
    <th><fmt:message key="admin.table_activityID_col_name"/></th>
    <th><fmt:message key="admin.table_userId_col_name"/></th>
    <th><fmt:message key="admin.table_action_name"/></th>
    <caption><fmt:message key="admin.table_name"/></caption>
    <c:forEach items="${sessionScope.requestList}" var="reqList">
        <tr>
            <td><c:out value="${reqList.requestId}"/></td>
            <td><c:out value="${reqList.type}"/></td>
            <td><c:out value="${reqList.activity.name}"/></td>
            <td><c:out value="${reqList.user.login}"/></td>
            <td><select name="opt${reqList.requestId}" required>
                <option value="true"><fmt:message key="admin.req_confirm"/></option>
                <option value="false" selected="selected"><fmt:message key="admin.req_reject"/></option>
            </select></td>
        </tr>
    </c:forEach>
</table>
</div>
<div class="col md-12 col lg-12 d-flex justify-content-center">
    <div class="paginationCenter">
        <div class="pagination">
            <c:if test="${currentPage != 1 }">
                <a href="${pageContext.request.contextPath}/administrate?page=${currentPage - 1}">&laquo;</a>
            </c:if>
            <c:forEach begin="1" end="${noOfPages}" var="i">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        <a href="" class="active">${i}</a>
                    </c:when>
                    <c:otherwise>
                        <a href="${pageContext.request.contextPath}/administrate?page=${i}">${i}</a>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <c:if test="${currentPage lt noOfPages}">
                <a href="${pageContext.request.contextPath}/administrate?page=${currentPage + 1}">&raquo;</a>
            </c:if>
        </div>
    </div>
</div>
<input type="submit" class="main__btn" value="${admin}">
</form>
</body>
</html>
