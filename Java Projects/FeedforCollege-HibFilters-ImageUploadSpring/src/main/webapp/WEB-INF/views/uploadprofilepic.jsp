<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="menu.jsp"%>
	<c:out value="${sessionScope.user.firstName}"></c:out>
	<img class="img-circle" alt="140x140"
		style="width: 150px; height: 150px;"
		src="<c:url value="/images/${sessionScope.user.profilepicName }"/>"
		data-holder-rendered="true">
	<br />
	<form:form class="form-group" action="picpic" method="post"
		modelAttribute="fileObj" enctype="multipart/form-data">

		<tr>
			<td><div>
					<label>Change Profile Photo(Max 5MB): </label>
					<form:input path="fileabc" name="fileabc" type="file" /></td>
		</tr>
		<div>
			<input style="padding-right: 10px;" id="bigbutton" type="submit"
				value="Upload" /> <br> <br>
		</div>
	</form:form>

	<div style="background-color: white;">
		<%@include file="footer.jsp"%>
	</div>
</body>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</html>