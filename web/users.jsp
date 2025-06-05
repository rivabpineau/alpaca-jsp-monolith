<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>User Administration</title></head>
<body>
  <h2>Users</h2>
  <ul>
<%
    java.util.List<com.alpacatours.model.User> list =
        (java.util.List<com.alpacatours.model.User>)request.getAttribute("users");
    if (list != null) {
        for (com.alpacatours.model.User u : list) {
%>
    <li><%= u.getUsername() %> (<%= u.getRole() %>)</li>
<%
        }
    }
%>
  </ul>
  <a href="register.jsp">Register New User</a> | <a href="index.jsp">Home</a>
</body>
</html>
