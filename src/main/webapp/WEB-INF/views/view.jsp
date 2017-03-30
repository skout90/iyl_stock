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
    <h1>최근 공시 상세</h1>
    <button type="button" class="btn btn-primary" onclick="history.back()">목록</button>
    <br>
    <table class="table">
        <tbody>
            <tr>
                <td>${resultMap.title}</td>
            </tr>
            <tr>
                <td><fmt:formatDate value="${resultMap.regDt}" pattern="MM-dd HH:mm"/></td>   
            </tr>
            <tr>
                <td style="white-space: pre-line;">
                    ${resultMap.contents}
                </td>
            </tr>
            <tr>
                <td>
                    <button type="button" class="btn btn-primary" onclick="history.back()">목록</button>
                </td>
            </tr>
        </tbody>
    </table>
</body>
</html>
