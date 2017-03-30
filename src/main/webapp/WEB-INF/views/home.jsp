<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<title>IYL Stock</title>
</head>
<body>
    <h1>최근 공시 리스트</h1>
    <table class="table">
        <tbody>
        	<c:forEach items="${resultList}" var="item">
        		<tr>
                    <td><a href="/schedule/${item.seqno}">${item.title}</a></td>
                    <td>
                        <fmt:formatDate value="${item.regDt}" pattern="MM-dd HH:mm"/>   
                    </td>
                </tr>
        	</c:forEach> 
        </tbody>
    </table>
</body>
</html>
