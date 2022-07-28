<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--@elvariable id="person" type="pl.coderslab.persistence.entities.Person"--%>
<form:form action="/persons/form" method="post" modelAttribute="person">
    <form:label path="login">Wpisz login</form:label>
    <form:input path="login"/>
    <form:label path="password">Wpisz haslo</form:label>
    <form:password path="password"/>
    <form:label path="email">Wpisz login</form:label>
    <form:input path="email"/>
    <input type="submit"/>
</form:form>

