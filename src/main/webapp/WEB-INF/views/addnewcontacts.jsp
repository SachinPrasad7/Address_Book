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
    
    <form action="addNewUser" modelAttribute="newuser" method="post" onsubmit="return validateUserID()">
    <form:errors path="*" Class="error message" Style="width: 900px"/>
        <c:if test="${not empty message}">
            <h4 class="error message" style="color: Red;font-size: 25px;margin-left: 400px;">${message}</h4>
        </c:if>
      <div class="container">
    
          <a href="homePage" class="link2">Home Page</a>
          <br/> <br/> <br/> <br/>
          
            <div class="row">
                <div class="col-10">
            <label for="fname">Enter Name:</label>
          </div>
           <div class="col-40"> 
           <input type="text" id="name" size="25" name="name" placeholder="Enter Name" required>
           </div>
           <br />
           <div class="col-10">
            <label for="fname">Enter Phone Number:</label>
          </div>
           <div class="col-40"> 
           <input type="text" id="phone" size="13" name="phone" placeholder="Enter Phone Number" required>
           </div>
            <br />
            <div> 
          <input type="submit" value="Submit">
        	</div>
        	</div>
    </form>
  </div>

</body>
</html>