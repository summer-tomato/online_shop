<%@ page session="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDate" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/address/resources/css/common.css">
<title>住所録(更新画面)</title>
</head>
<body>
	<form:form modelAttribute="addressBookForm" action="/address/book">
		<div class="header">
			<span class="titleName">住所録</span>
			<div class="data"><%=LocalDate.now() %></div>
		</div>
		<div class="main">
			<div class="message">
				<c:out value="${message}" />
			</div>
			<div>
				<span class="itemName">従業員番号:</span>
				<c:out value="${addressBookForm.id}" />
				<form:hidden path="id" />
			</div>
			<div>
				<span class="itemName">名前:</span>
				<form:input path="name" size="31" />
			</div>
			<div>
				<span class="itemName">電話番号:</span>
				<form:input path="phone" size="31" />
			</div>
			<div>
				<span class="itemName">住所:</span>
				<form:input path="address" size="31" />
			</div>
		</div>
		<div class="footer">
			<div>
				<input type="submit" name="doUpdate" value="反映" />
			</div>
			<div>
				<input type="submit" name="toInit" value="取消" />
			</div>
		</div>
	</form:form>
</body>
</html>