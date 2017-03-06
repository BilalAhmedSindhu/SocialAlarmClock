
<%@ page contentType="text/xml" %>
<Response>
    <Say>Please hold on while we connect you to the requestor</Say>
 
    <Dial><%= request.getParameter("number") %></Dial>
</Response>