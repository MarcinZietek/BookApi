<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--@elvariable id="book" type="pl.coderslab.persistence.entities.Book"--%>
<form:form action="/books1/form" method="post" modelAttribute="book">
    <form:hidden path="id"/>
    <form:label path="title">Wpisz tytul</form:label>
    <form:input path="title"/>
    <form:label path="rating">Wpisz ocene</form:label>
    <form:input path="rating" type="number"/>
    <form:label path="description">Wpisz opis</form:label>
    <form:input path="description"/>
    <form:select itemValue="id" itemLabel="name"
                 path="publisher.id" items="${availablePublishers}"/>
    <form:select itemLabel="firstName" itemValue="id"
                 path="authors" items="${availableAuthors}" multiple="true"/>
    <input type="submit"/>
</form:form>
