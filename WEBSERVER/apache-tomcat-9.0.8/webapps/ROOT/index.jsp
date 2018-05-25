<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>Temperatura</title>
		<script>
			setTimeout(
				function() {
					location.href = "/temperatura";
				},
				300000
			);
		</script>
	</head>
	<body>
		<p>
			A página mostra o último valor capturado pelos sensores em questão (3 sensores são simulados). Há um script para atualização automática da página para cada 5 minutos. Para atualização antes disso, atualizar a página pelo navegador.
		</p>
		<p>
		Sensor 0: ${sensors.get('sensor0')}
		</p>
		<p>
		Sensor 1: ${sensors.get('sensor1')}
		</p>
		<p>
		Sensor 2: ${sensors.get('sensor2')}
		</p>
		
		<p>
			<a href="/relatorio">Emitir relatório de temperaturas salvas</a>
		</p>
	</body>
</html>
