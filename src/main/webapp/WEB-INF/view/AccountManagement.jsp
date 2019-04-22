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

<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="styles/style.css">
    <title>${title}</title>
</head>
<body>
<!-- HEADER -->
<jsp:include page="/templates/header.jsp"/>
<!-- /HEADER -->
<h1>Account page</h1>
</body>
</html>