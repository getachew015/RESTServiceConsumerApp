<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="java.text.*"%>


<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Search Flights</title>
	<style>
		#input {
		  font-family: arial, sans-serif;
		  border-collapse: collapse;
		  width: 50%;
		}
		
		table {
		  font-family: arial, sans-serif;
		  border-collapse: collapse;
		  width: 100%;
		}

		td, th {
		  border: 1px solid #dddddd;
		  text-align: left;
		  padding: 8px;
		}
		
		tr:nth-child(even) {
		  background-color: #dddddd;
		}
	</style>	
</head>
<body >

	<div class="panel panel-primary">
		<div class="panel-heading">
			<h4>Search Flights</h4>
		</div>
		<br><br>
		<div class="panel-body">
			
	<form:form  method="POST" action="searchFlights" commandName="command" >
				<table id="input">
					<tr>
						<td colspan="2">Departure</td>
						<td><form:input path="source"/></td>
					</tr>
					<tr>
						<td colspan="2">Destination</td>
						<td><form:input path="destination"/></td>
					</tr>
					<tr>
						<td colspan="2">Travel Date</td>
						<td><form:input path="journeyDate"/></td>
					</tr>
					<tr>
						<td> <input id="submit" type="submit"></td>
					</tr>
				</table>
				
				<br><br>
		<c:if test="${(size) gt 0}">
		<h4>Consuming REST service JSON Response</h4>
					<table>
					  <tr>
					    <th>Airlines</th>
					    <th>Arrival TIme</th>
					    <th>Departure TIme</th>
					    <th>Fare</th>
					    <th>FlightId</th>
					    <th>Available Seats</th>
					  </tr>
					  <!-- iterate over list of flights here -->
					  <c:forEach var="flight" items="${availableFlights}">
						  <tr>
						    <td><form:label path="airlines">${flight.airlines}</form:label></td>
						    <td><form:label path="arrivalTime">${flight.arrivalTime}</form:label></td>
						    <td><form:label path="departureTime">${flight.departureTime}</form:label></td>
						    <td><form:label path="fare">${flight.fare}</form:label></td>
						    <td><form:label path="flightId">${flight.flightId}</form:label></td>
						    <td><form:label path="seatCount">${flight.seatCount}</form:label></td>
						  </tr>						  
					  </c:forEach>
				</table>
			</c:if>
			<c:if test="${(size) eq 0 }">
				<h5 style="color:red;">No flights were found for the search! Try different</h5>
			</c:if>
 		</form:form>
		</div>
	</div>

	<script type="text/javascript">
		
	</script>

</body>

</html>
