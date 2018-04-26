<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RESET PASSWORD FORM</title>
<style>
.form-gap {
    padding-top: 70px;
}
.white-box {
    background-color: white;
    width:50%;

    color: green;
 margin-left:250px;
  border: 1px solid #aaaaaa;
}
input {
padding-top:20px;
  width: 60%;
  font-size: 17px;
  font-family: Raleway;
  border: 1px solid #aaaaaa;
}

</style>
<script>
function resetPasswordForm() {
	  var rpwd = document.forms["resetForm"]["rpwd"].value;
	  var rtypwd = document.forms["resetForm"]["rtypwd"].value;


	  if(rpwd!="" && rtypwd!=""){
		if(rpwd==rtypwd){
		       document.resetForm.submit();
			}
		else
			{
			alert("Passwords dint match");
return false;
			}
		}else
			{
alert("CANNOT SUBMIT EMPTY FORM");
return false;
			}
}
</script>
</head>
<body >
<div>
<%@include file="myHeader.jsp"%>
</div>

<h3 style="color:green; margin-left:250px;">RESET PASSWORD FORM</h3>
<form method="POST" action="manageActivities">
<div class="white-box">
<label style="color:red; padding-right:20px;padding-left:10px">${requestScope.nouserEr}</label><br>
<label style="padding-right:20px;padding-left:10px">Username</label>
<input style="margin-top:10px;padding-top:5px;" id="rusername" name="rusername"><br>
<label>Customer <input type="radio" name="userType" value="Customer"></label> <br>
<label>Administrator <input type="radio" name="userType" value="Admin"></label><br>
<label >Dealer <input type="radio" name="userType" value="Dealer"></label> 
<button style="padding-top:10px;margin-left:150px;" type="submit"> VALIDATE USER </button>
</div>
</form>
<%System.out.println(request.getAttribute("userExists")); 
if(request.getAttribute("userExists")!=null && "true".equalsIgnoreCase(request.getAttribute("userExists").toString())){
%>
<form method="POST" action="changePassword" name="resetForm">
<div class="white-box" style="margin-top:25px;">
<label style="padding-right:20px;padding-left:10px">Password</label>
<input style="margin-top:10px;padding-top:5px;" id="rpwd" name="rpwd"><br>
<label style="padding-right:20px;padding-left:10px">Re-Type Password</label>
<input style="margin-top:10px;padding-top:5px;" id="rtypwd" name="rtypwd"><br>
<button style="padding-top:10px;margin-left:150px;" type="submit" onclick="return resetPasswordForm()"> CHANGE PASSWORD </button>
</div>
</form>
<%} %>
</body>
</html>