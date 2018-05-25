<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>Relatório</title>
	</head>
	<body>
		<p>
		<b>Relatorio</b>
		<br/>
		DATA - Sensor - Valor medido
		<c:forEach var="p" items="${relatorio}">
			${p.get('dt')} - ${p.get('sensor_id')} - ${p.get('temperature')} ºC <br/>
		</c:forEach>
		</p>
	</body>
</html>
