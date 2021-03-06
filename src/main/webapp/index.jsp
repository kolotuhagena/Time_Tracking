<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<fmt:setBundle basename="language"/>
<fmt:message key="title" var="title"/>
<fmt:message key="header.logo" var="logo"/>
<fmt:message key="index.welcome" var="welcome"/>
<fmt:message key="index.description" var="description"/>
<fmt:message key="index.join" var="join"/>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="styles/style.css">
    <title>${title}</title>
</head>
<body>
<jsp:include page="WEB-INF/view/Components/header.jsp"/>
<section id="content">
    <div class="wrapper">
        <h1 class="content__title">${welcome}</h1>
        <p class="content__text">${description}</p>
        <a href="${pageContext.request.contextPath}/home"><input type="button" value="${join}" class="main__btn"></a>
    </div>
</section>
</body>
</html>