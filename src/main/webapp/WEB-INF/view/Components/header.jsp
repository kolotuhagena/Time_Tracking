<%--
  Created by IntelliJ IDEA.
  User: WK
  Date: 3/22/2019
  Time: 2:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<fmt:setBundle basename="language"/>

<fmt:message key="header.logo" var="logo"/>
<fmt:message key="header.main" var="main"/>
<fmt:message key="header.account" var="account"/>
<fmt:message key="header.admin" var="admin"/>


<header class="main-header">
    <div class="wrapper main-header__wrapper">
        <a href="${pageContext.request.contextPath}/" class="main-header__logo">${logo}</a>
        <ul class="main-header__menu">
            <c:if test="${login != null}">
                <li class="main-header__list"><a href="${pageContext.request.contextPath}/home" class="main-header__link">${main}</a></li>
                <li class="main-header__list"><a href="${pageContext.request.contextPath}/account" class="main-header__link">${account}</a></li>
            </c:if>
            <c:if test="${IsAdministrator == true}">
                <li class="main-header__list admin"><a href="${pageContext.request.contextPath}/administrate">${admin}</a></li>
            </c:if>
        </ul>
    </div>
    <div class="lang">
            <span class="lang__item"><a href="${pageContext.request.contextPath}/localeUa" class="lang__link">
                    <p>UA</p>
                </a></span>
        <span class="lang__item"><a href="${pageContext.request.contextPath}/localeEn" class="lang__link">
                    <p>ENG</p>
                </a></span>
        <c:if test="${login != null}">
            <a href="${pageContext.request.contextPath}/logout" class="lang__link">Logout<i class=""></i> </a>
        </c:if>


    </div>
</header>
