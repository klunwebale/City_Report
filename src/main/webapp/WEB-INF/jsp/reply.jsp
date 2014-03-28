<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  

<%@ page import="java.util.*" %>

<html>

	<head>
		<title> Result </title>
		<style>
		
		.link{
		
		color:#989898;
		font-size: 22px
		}
		
		</style>
	</head>

<%
	String population = (String)request.getAttribute("population");
	String populationDensity = (String)request.getAttribute("populationDensity");
	String areaTotal = (String)request.getAttribute("areaTotal");
%>

	<body>
		<center>
		<h2 style="color:#888888 ">Result</h2> </br>
		<h3>Total Population: <%= population %> </h3>
		<h3>Population Density: <%= populationDensity %> </h3>
		<h3>Area Total: <%= areaTotal %> </h3>	</br>
		<br></br>
		<a class="link" href="/CityReport/index.jsp">Main Menu</a>
		</center>
	</body>

</html>