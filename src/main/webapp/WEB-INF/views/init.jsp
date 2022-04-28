<%@ page session="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.time.LocalDate" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>

<html>
<head>
<link rel="stylesheet" type="text/css" href="/address/resources/css/common.css" />
	<title>住所録(初期画面)</title>
</head>
<body>

	<form:form modelAttribute="addressBookForm" action="/address/book">
		<div class="header">
			<span class="titleName">住所録</span>
			<div class="date"><%=LocalDate.now() %></div>
		</div>
		<div class="main">
			<div class="message">
				<c:out value="${message}" />
			</div>
			<div>
				<span class="itemName">従業員番号:</span>
				<form:input path="id" size="31" />
			</div>
		</div>
		<div class="footer">
			<div>
				<input type="submit" name="refer" value="参照" />
			</div>
			<div>
				<input type="submit" name="update" value="更新" />
			</div>
			<div>
				<input type="submit" name="add" value="追加" />
			</div>
			<div>
				<input type="submit" name="list" value="一覧">
			</div>
		</div>
	</form:form>
</body>
</html>
