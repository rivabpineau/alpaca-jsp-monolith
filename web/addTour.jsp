<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<html>
<head><title>Add Tour</title></head>
<body>
  <h2>Add Tour</h2>
  <html:form action="addTour.do">
    Title: <html:text property="title" /><br/>
    Location: <html:text property="location" /><br/>
    Price: <html:text property="price" /><br/>
    Description: <html:text property="description" /><br/>
    Capacity: <html:text property="capacity" /><br/>
    Guide ID: <html:text property="guideId" /><br/>
    <html:submit value="Save" />
  </html:form>
  <a href="tours.do">Back to Tours</a>
</body>
</html>
