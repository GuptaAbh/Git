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
	
	<form:form class="form-group" action="picpic" method="post"
		modelAttribute="fileObj" enctype="multipart/form-data">

		<tr>
			<td><div>
					<label>Change Profile Photo(Max 5MB): </label>
					<form:input path="fileabc" name="fileabc" type="file" />
				
			</td>
		</tr>
		<div>
			<input style="padding-right: 10px;" id="bigbutton" type="submit"
				value="Upload" /> <br> <br>
		</div>
	</form:form>

	<br/><br/>




</body>
</html>