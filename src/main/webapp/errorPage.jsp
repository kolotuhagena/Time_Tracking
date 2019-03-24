<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html" language="java" pageEncoding="UTF-8" %>


<fmt:setBundle basename="language"/>
<fmt:message key="title" var="title"/>
<fmt:message key="messageHelper.error" var="err"/>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="styles/style.css">
  <title>${title}</title>
</head>
<body>
<!-- HEADER -->
<jsp:include page="WEB-INF/view/Components/header.jsp"/>
<section>
  <div >
    <div >
      ${servletException}
      ${IOException}
      ${exception}
      ${nullPage}
      <div>
        <h3>${err}</h3>
      </div>
    </div>
  </div>
</section>
</body>
</html>