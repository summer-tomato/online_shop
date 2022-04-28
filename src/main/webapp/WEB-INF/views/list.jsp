<%@ page session="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDate" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/address/resources/css/common.css">
<title>住所録(一覧画面)</title>
</head>
<body>
	<form:form modelAttribute="addressBookForm" action="/address/book">
		<div class="header">
			<span class="titleName">住所録</span>
			<div class="date"><%=LocalDate.now() %></div>
		</div>
		<div>
			社員数:
			<c:out value="${employeeCount}"></c:out>
			人
		</div>
		<table>
			<tr>
				<th>従業員番号</th>
				<th>名前</th>
				<th>電話番号</th>
				<th>住所</th>
			</tr>
			<c:forEach items="${employeeList}" var="employee" varStatus="status">
				<c:choose>
					<c:when test="${status.count % 2 == 0}">
						<tr class="even">
							<td>${employee.id}</td>
							<td>${employee.name}</td>
							<td>${employee.phone}</td>
							<td>${employee.address}</td>
						</tr>
					</c:when>
					<c:otherwise>
						<tr>
							<td>${employee.id}</td>
							<td>${employee.name}</td>
							<td>${employee.phone}</td>
							<td>${employee.address}</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</table>
		<div class="listFooter">
			<input type="submit" name="toInit" value="戻る" />
		</div>
	</form:form>
</body>
</html>