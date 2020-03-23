<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="2">
        <tr><th>번호</th><th>이미지</th><th>내용</th><th>댓글수</th></tr>
        <c:forEach items="${list}" var="feed">
            <tr>
               <!-- <td><c:out value="${feed.id}"/> </td>
                <td><img width="500px" height="auto" src="<c:out value="${feed.images[0].url}"/>"/> </td>
                <td><p style="max-width: 300px"><c:out value="${feed.text}"/></p> </td>
                <td><c:out value="${feed.commentCount}"/></td>-->
                <td>0</td>
                <td>0</td>
                <td>0</td>
            </tr>
        </c:forEach>
    </table>
</body>


</html>
