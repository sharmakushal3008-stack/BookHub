<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, com.bookhub.model.Book" %>

<html>
<head>
    <title>All Books</title>
    <style>
        table {
            border-collapse: collapse;
            width: 60%;
        }
        th, td {
            padding: 8px;
            border: 1px solid #444;
            text-align: left;
        }
        th {
            background: #f0f0f0;
        }
        a.button {
            padding: 6px 10px;
            background: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 4px;
        }
        a.button:hover {
            background: #0056b3;
        }
    </style>
</head>

<body>

<h2>All Books</h2>

<a class="button" href="${pageContext.request.contextPath}/books/add">Add Book</a>
<br/><br/>

<table>
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Author</th>
        <th>Price</th>
        <th>Action</th>
    </tr>

    <%
        // Retrieve list from model
        List<Book> books = (List<Book>) request.getAttribute("books");
        if (books != null && !books.isEmpty()) {
            for (Book b : books) {
    %>
                <tr>
                    <td><%= b.getBookId() %></td>
                    <td><%= b.getTitle() %></td>
                    <td><%= b.getAuthor() %></td>
                    <td><%= b.getPrice() %></td>
                    <td>
                        <a class="button"
                           href="<%= request.getContextPath() %>/books/delete/<%= b.getBookId() %>">
                            Delete
                        </a>
                    </td>
                </tr>
    <%
            }
        }
    %>

</table>

</body>
</html>
