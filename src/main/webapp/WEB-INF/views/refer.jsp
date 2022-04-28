<%@ page session="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDate" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/address/resources/css/common.css">
<title>住所録(参照画面)</title>
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
				<c:out value="${addressBookForm.id}" />
			</div>
			<div>
				<span class="itemName">名前:</span>
				<c:out value="${addressBookForm.name}" />
			</div>
			<div>
				<span class="itemName">電話番号:</span>
				<c:out value="${addressBookForm.phone}" />
			</div>
			<div>
				<span class="itemName">住所:</span>
				<c:out value="${addressBookForm.address}" />
			</div>
		</div>
		<div class="footer">
			<input type="submit" name="toInit" value="戻る" />
		</div>
	</form:form>
</body>
</html>