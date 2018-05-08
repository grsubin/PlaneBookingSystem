<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/main.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/plane.css">

</head>
<body>
	<div class = "wrapper">
		<div class = "title">
			<h1>
				<a href="${pageContext.request.contextPath}/">Plane Booking System</a>
			</h1>
		</div>
		<div class="nav">
			<div class="nav-items">
				<a href="${pageContext.request.contextPath}/planes">Planes</a>
				<a href="${pageContext.request.contextPath}/plane-form">Plane Form</a>
			</div>
		</div>
	
		<div class="main">
			<c:forEach var="row" items="${planes}">
				<div class="list">
					<p>Plane Id: ${row.planeId}</p>
					<p>Plane Name: ${row.planeName}</p>
					<p>Plane No.: ${row.planeNo}</p>
					<p>Passenger Seat: ${row.passengerSeat}</p>
				</div>
			</c:forEach>
		</div>
	</div>




</body>
</html>