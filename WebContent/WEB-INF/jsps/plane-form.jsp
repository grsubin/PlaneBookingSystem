<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/main.css">
<link rel ="stylesheet" type ="text/css" href="${pageContext.request.contextPath}/static/css/form.css">
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
			<sf:form method = "post" commandName="plane" action = "${pageContext.request.contextPath}/do-add-details" >
				<fieldset>
					<legend>Plane Detail Form</legend>
					<div class="form-grid">
						<label >Plane Name: </label>		
						<sf:input type="text" path="planeName" name="planeName" />
						<sf:errors path="planeName" cssClass="error"/>	
						<label >Plane Number: </label>		
						<sf:input type="text" path="planeNo" name="planeNo" />
						<sf:errors path="planeNo" cssClass="error"/>
						<label >Passenger Seat: </label>
						<sf:input type="text" path="passengerSeat" name="passengerSeat" />
						<sf:errors path="planeNo" cssClass="error"/>
						<div class="buttons">
							<input type="submit" value="Submit"> 
							<input type="reset" value="Reset">
						</div>
					</div>
				</fieldset>
			</sf:form>
		</div>

		<div class="current">
			<fieldset>
			<legend>Current Entry </legend>
						
			<c:forEach var="row" items="${recPlane}">
	  		  Plane Id: ${row.planeId}<br/>
	 		  Plane Name: ${row.planeName}<br/>
	 		  Plane No.: ${row.planeNo} <br/>
	  		  Passenger Seat: ${row.passengerSeat} <br/><br/><br/>
			</c:forEach>
			${success}
			</fieldset>
		</div>
	
	</div>


</body>
</html>