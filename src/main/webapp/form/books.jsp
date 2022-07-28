<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach var="book" items="${books}">

        <p>${book.id}</p>
        <p>${book.title}</p>
        <p>${book.rating}</p>
        <p>${book.description}</p>
        <p>${book.publisher.name}</p>
    <p><a href="/books1/form/delete/${book.id}">delete </a> </p>
    <p><a href="/books1/form/edit/${book.id}">edit </a> </p>


</c:forEach>