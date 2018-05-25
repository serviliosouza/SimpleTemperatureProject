<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>Relatório</title>
	</head>
	<body>
		<p>
		Relatorio<br/>
		<c:forEach var="p" items="${relatorio}">
			${p}
		</c:forEach>
		</p>
	</body>
</html>
