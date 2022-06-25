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
    
    <form action="addnewuser" modelAttribute="newuser" onsubmit="return validateUserID()">
    
      <div class="container">
    
          <a href="HomePage" class="link2">Home Page</a>
          <br/> <br/> <br/> <br/>
          
            <div class="row">
                <div class="col-10">
            <label for="fname">Enter Name:</label>
          </div>
           <div class="col-40"> 
           <input type="text" id="name" name="name" placeholder="Enter Name">
           </div>
           <br />
           <div class="col-10">
            <label for="fname">Enter Phone Number:</label>
          </div>
           <div class="col-40"> 
           <input type="text" id="phone" name="phone" placeholder="Enter Phone Number">
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