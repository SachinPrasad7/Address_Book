<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Real time info</title>
<link rel="stylesheet" href="/resources/css/style.css">
<script type="text/javascript" src="/resources/js/app.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>

	<h2 style="color: darkOrange; margin-left: 420px;">Address Book
		Application</h2>
	<div class="container">
		<table id="style2">
			<tr>
				<td><a href="homePage" class="link3">Home Page</a></td>
				<td>
					<h2>Other Address Book</h2>
			</tr>
			</td>
			<tr />
		</table>
		<table id="userdata">

			<thead>
				<tr>
					<th>Name</th>
					<th>Phone Number</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${otheraddressDetails}" var="temp">
					<tr>
						<td>${temp.name}</td>
						<td>${temp.phone}</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>