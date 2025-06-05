<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<html>
<head><title>Login</title></head>
<body>
  <h2>Login</h2>
  <html:form action="login.do">
    <html:text property="username" /><br />
    <html:password property="password" /><br />
    <html:submit value="Login" />
  </html:form>
  <a href="register.jsp">Register</a>
</body>
</html>
