<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<html>
<head><title>Register</title></head>
<body>
  <h2>Register</h2>
  <html:form action="register.do">
    <html:text property="username" /><br />
    <html:password property="password" /><br />
    <html:submit value="Register" />
  </html:form>
  <a href="login.jsp">Login</a>
</body>
</html>
