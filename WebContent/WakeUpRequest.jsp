<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
      href="./Design/stylesheet.css"
      type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Create a WakeUp Request</title>
</head>
<body>
<center>
		<h1>Create a Wake Up Request</h1>
		</center>
		<div align="right"><embed src=http://flash-clocks.com/free-flash-clocks-blog-topics/free-flash-clock-176.swf width=150 height=50 wmode=window type=application/x-shockwave-flash></embed></div>
		<br>

<FORM ACTION="CreateWakeUpRequest">
  Phone Number: <INPUT TYPE="TEXT" NAME="PhNumber"><BR>
  Time(24 Hours): <INPUT TYPE="TEXT" NAME="THours"><BR>
  Time(minutes): <INPUT TYPE="TEXT" NAME="TMinutes"><BR>
  Day: <INPUT TYPE="TEXT" NAME="Day"><BR>
  Month: <select name="Month">
    <option value="------">------</option>
 	<option value="January">January</option>
	<option value="February">February</option>
	<option value="March">March</option>
	<option value="April">April</option>
	<option value="May">May</option>
	<option value="June">June</option>
	<option value="July">July</option>
	<option value="August">August</option>
	<option value="September">September</option>
	<option value="October">October</option>
	<option value="November">November</option>
	<option value="December">December</option>
  </select>
  Year: <INPUT TYPE="TEXT" NAME="Year"><BR>
 
  <CENTER><INPUT TYPE="SUBMIT" VALUE="Submit Request"></CENTER>
</FORM>
<br>
	<h3><a href="MembersHome.jsp">Home</a></h3>
		
	<h3><a href="LogOut">Log Out</a></h3>
		
</body>
</html>