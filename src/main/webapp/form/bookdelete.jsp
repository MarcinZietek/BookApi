<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--@elvariable id="book" type="pl.coderslab.persistence.entities.Book"--%>
<form:form action="/books1/form/delete" method="post" modelAttribute="book">
    Are you sure?
    <form:hidden path="id"/>
    <form:hidden path="title"/>
    <form:hidden path="rating"/>
    <form:hidden path="description"/>
    <form:hidden path="publisher.id"/>
    <form:hidden path="authors"/>
    <input type="submit"/>
</form:form>
