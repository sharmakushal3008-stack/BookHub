<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <body>
    <h2>Add Book</h2>
    <form action="${pageContext.request.contextPath}/books/add" method="post">
      Title: <input type="text" name="title"/><br/>
      Author: <input type="text" name="author"/><br/>
      Price: <input type="number" step="0.01" name="price"/><br/><br/>
      <input type="submit" value="Add"/>
    </form>
    <a href="${pageContext.request.contextPath}/books/list">View Books</a>
  </body>
</html>
