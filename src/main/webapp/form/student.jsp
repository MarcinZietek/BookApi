<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--@elvariable id="book" type="pl.coderslab.web.dtos.Student"--%>
<form:form action="/students" method="post" modelAttribute="student">

    <form:label path="firstName">imie</form:label>
    <form:input path="firstName"/>
    <form:label path="lastName">nazwisko</form:label>
    <form:input path="lastName"/>
    <form:label path="gender">plec</form:label>
    <form:radiobuttons path="gender" items="${availableGenders}"/>
    <form:label path="country">kraj</form:label>
    <form:select path="country" items="${availableCountries}"/>
    <form:label path="notes">notatki</form:label>
    <form:textarea path="notes"/>
    <form:label path="mailingList">mailing list</form:label>
    <form:checkbox path="mailingList"/>
    <form:label path="programmingSkills">skilsy</form:label>
    <form:select path="programmingSkills" items="${availableProgrammingSkills}" multiple="true"/>
    <form:label path="hobbies">hobbisy</form:label>
    <form:checkboxes path="hobbies" items="${availableHobbies}"/>
    <input type="submit"/>
</form:form>
