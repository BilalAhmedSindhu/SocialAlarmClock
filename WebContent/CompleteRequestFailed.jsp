<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
      href="./Design/stylesheet.css"
      type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Complete Request</title>
</head>
<body>
<center>
		<h1>Complete committed request</h1>
		<h2><font color="red">Request Failed. Either you are trying to complete a request which you have not committed to or the 5 minute windows has not arrived yet.</h2></font>
		<div align="right"><embed src=http://flash-clocks.com/free-flash-clocks-blog-topics/free-flash-clock-176.swf width=150 height=50 wmode=window type=application/x-shockwave-flash></embed></div>
		</center>
		<br>
		<FORM ACTION="CompleteRequestMakeCall">
  <b>Request ID committed to:<b/> <INPUT TYPE="NUMBER" NAME="ReqID"><BR>
  <CENTER><INPUT TYPE="SUBMIT" VALUE="Complete Request"></CENTER>
</FORM>
		<h2><a href="MembersHome.jsp">Home</a></h2>
		<h2><a href="WakeUpRequest.jsp">Create a wake up request</a></h2>
		<h2><a href="CommitToARequest">Commit to a request</a></h2>
		<h2><a href="LogOut">Log Out</a></h2>
		<br>
		
</body>
</html>