<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <script
            src="http://code.jquery.com/jquery-3.3.1.js"
            integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
            crossorigin="anonymous">
    </script>

    <title>Title</title>
</head>
<body>
<h1>Detail HERE</h1>

    <c:forEach items="${list}" var="feed"></c:forEach>
    <h3><c:out value="${feed.text}"/></h3>




<script>



</script>
</body>



</html>
