<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Detail HERE</h1>
    ${feed.id}
    <div style="float: left">
        <c:forEach items="${feed.MDImage}" var="image">
            <img src="${image.url}"/>
        </c:forEach>
    </div>
    <div style="float: left;">
        ${feed.content}
    </div>
    <input type="checkbox" name="LikeCheck" value="yyy" checked>

<hr>

    <div>
        ID: <input type="text" style="width: 80px;">
        댓글<input type="text">
    </div>
    <div id="commentRoot" style="float: left;">
        <c:forEach items="${comment}" var="comment">
            <div id="${comment.id}">
                    ${comment.id}
                    ${comment.userId}
                        ${comment.text}
                <hr/>
            </div>
        </c:forEach>

    </div>

    <div>
        번호<input id="userId"><br>
        댓글<input type="text" id="commentText">
    </div>

</body>
</html>
