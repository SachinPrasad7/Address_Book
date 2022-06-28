<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<!-- Static content -->
<link rel="stylesheet" href="/resources/css/style.css">
<script type="text/javascript" src="/resources/js/app.js"></script>

<title>Spring Boot</title>
</head>
<body>
	<h1>Address Book Application</h1>
	<form action="/validation" modelAttribute="userDetails" onsubmit="return validateUserName()">
		<div class="container">
			<div class="row">
				<div class="col-10">
					<label for="fname">Enter User Name:</label>
				</div>
				<div class="col-40">
					<input type="text" size="25" id="userId" name="userId" placeholder="User Name" required>
				</div>
				<br />
				<div>
					<input type="submit" value="Submit">
				</div>
			</div>
	</form>

</body>
</html>