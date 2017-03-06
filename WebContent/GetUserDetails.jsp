<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
      href="./Design/stylesheet.css"
      type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<H1 ALIGN="CENTER">Social Alarm User Registration</H1>
<div align="right"><embed src=http://flash-clocks.com/free-flash-clocks-blog-topics/free-flash-clock-176.swf width=150 height=50 wmode=window type=application/x-shockwave-flash></embed></div>
<FORM ACTION="GetUserDetails">
  First Name: <INPUT TYPE="TEXT" NAME="Fname"><BR>
  Last Name: <INPUT TYPE="TEXT" NAME="Lname"><BR>
  Year of Birth: <INPUT TYPE="TEXT" NAME="YearB"><BR>
  <select name="MonthB">
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
  Date: <INPUT TYPE="TEXT" NAME="DayB"><BR>
  <HR>
  Gender:<BR>
  &nbsp;&nbsp;<INPUT TYPE="RADIO" NAME="Gender"
                     VALUE="Female">Female<BR>
  &nbsp;&nbsp;<INPUT TYPE="RADIO" NAME="Gender"
                     VALUE="Male">Male<BR>
  Country: <INPUT TYPE="TEXT" NAME="Country"><BR>
  City: <INPUT TYPE="TEXT" NAME="City"><BR>
  Email: <INPUT TYPE="TEXT" NAME="Email"><BR>
  Account Password: 
  <INPUT TYPE="PASSWORD" NAME="PassW"><BR>
  Confirm Password:
  <INPUT TYPE="PASSWORD" NAME="PassW"><BR><BR>
  <CENTER><INPUT TYPE="SUBMIT" VALUE="Submit"></CENTER>
</FORM>
</body>
</html>