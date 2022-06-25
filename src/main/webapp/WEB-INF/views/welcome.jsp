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


	<c:url var="Address" value="/myaddress/">
		<c:param name="userId" value="${userDetails.userId}" />
	</c:url>
	<div class="container">

		<caption>
			<h3 style="margin-left: 35%;">Welcome ${userName} !!</h3>
		</caption>
		<a href="myaddress" class="link">My Address Book</a> <a href="addNew"
			class="link">Add New Contacts</a> <a href="otheraddress" class="link">Other
			Address Book</a> <br />
		<br />
		<br /> <a href="uniqueContacts" class="link4">List of friends that
			are unique to Other Address Book</a>

	</div>
	</form>
	</div>

</body>
</html>