<%@ page session="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.time.LocalDate" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page import="java.time.ZonedDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%! ZonedDateTime zoned= ZonedDateTime.now(); %>
<%! DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M月d日(E)"); %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/sales/resources/css/common.css" />
	<title>売上システム（登録画面）</title>
</head>
<body>

	<form:form modelAttribute="salesForm" action="/sales/system">
		<div class="header">
			<span class="titleName">鈴木オンラインショップ  <%=dtf.format(zoned)%></span>
		</div>
		<div class="footer">
			<div class="doneMessage">
				<c:out value="${doneMessage}" />
			</div>
			<div class="errorMessage">
				<c:out value="${errorMessage}" />
			</div>
			<div>
				<span class="salesId">売上ID:<c:out value="${salesId}" /></span>
			</div>
			<div>
				<span class="tableName">売上明細</span>
				<table>
					<tr><th>商品ID</th><th>商品名</th><th>単価</th><th>点数</th><th>小計</th></tr>
					<c:forEach var="obj" items="${salesForm.allList}" varStatus="loop">
						<tr>
							<td>${obj.id}</td>
							<td>${obj.name}</td>
							<td>${obj.price}</td>
							<td>${obj.quantity}</td>
							<td>${obj.subtotal}</td>
						</tr>
					</c:forEach>
				</table>
				合計：${total}円
			</div>
			<div>
				<input type="submit" name="end" value="終了" />
			</div>
		</div>
	</form:form>
</body>
</html>
