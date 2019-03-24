<%--
  Created by IntelliJ IDEA.
  User: WK
  Date: 3/22/2019
  Time: 7:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<fmt:setBundle basename="language"/>
<fmt:message key="title" var="title"/>
<fmt:message key="input.username" var="username"/>
<fmt:message key="input.SignIn" var="signin"/>
<fmt:message key="input.password" var="password"/>
<fmt:message key="input.email" var="email"/>
<fmt:message key="input.registration" var="registration"/>
<fmt:message key="input.registr" var="registr"/>
<fmt:message key="input.submit" var="submit"/>
<html>

<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="styles/style.css">
    <title>${title}</title>
</head>

<body>
<jsp:include page="Components/header.jsp"/>
<section id="content">
    <div class="signin__wrapper">
        <div class="signin">
            <form action="home" method="post">
                <h2 class="signin__title">${signin}</h2>
                <div class="input-field">
                    <input type="text" id="inputUsername" required name="login" class="signin__input" placeholder="${username}">
                </div>
                <div class="input-field">
                    <input type="password" id="inputPassword" required name="password" class="signin__input" placeholder="${password}">
                </div>
                <button type="submit" class="main__btn main__btn--left" value="${submit}"></button>
            </form>
        </div>
        <div class="registr">
            <form method="post" action="registration">
                <h2 class="signin__title">${registr}</h2>
                <div class="input-field">
                    <input type="text" name="regUsername" required="" class="signin__input" placeholder="${username}">
                </div>
                <div class="input-field">
                    <input type="password" name="regPassword" required="" class="signin__input" placeholder="${password}">
                </div>
                <div class="input-field">
                    <input type="text" name="regEmail" required="" class="signin__input" placeholder="${email}">
                </div>
                <input type="submit" value="${registration}" class="main__btn main__btn--left">
            </form>
        </div>
    </div>
</section>
</body>
</html>
