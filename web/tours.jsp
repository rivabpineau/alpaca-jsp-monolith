<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<html>
<head><title>Tours</title></head>
<body>
  <h2>Tours</h2>
  <ul>
  <%
    java.util.List<com.alpacatours.model.Tour> list =
      (java.util.List<com.alpacatours.model.Tour>)request.getAttribute("tours");
    if (list != null) {
        for (com.alpacatours.model.Tour t : list) {
  %>
    <li><%= t.getTitle() %> - guide <%= t.getGuideId() %></li>
  <%
        }
    }
  %>
  </ul>
  <%
    com.alpacatours.model.User u = (com.alpacatours.model.User)session.getAttribute("user");
    if (u != null && u.getRole() != null && u.getRole().contains("ADMIN")) {
  %>
    <a href="addTour.jsp">Add Tour</a><br/>
  <%
    }
  %>
  <a href="index.jsp">Home</a>
</body>
</html>
