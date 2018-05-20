<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All Albums</title>
</head>
<body>
    <table border=1>
        <thead>
            <tr>
                <th>Album name</th>
                <th>Composer</th>
                <th>Genre</th>
                <th>songs's number</th>
                <th>Release Date</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${albums}" var="item">
                <tr>
                    <td><c:out value="${item.getAlbum()}" /></td>
                    <td><c:out value="${item.getComposer()}" /></td>
                    <td><c:out value="${item.getGenre()}" /></td>
                    <td><c:out value="${item.getNumber()}" /></td>
                    <td><fmt:formatDate pattern="dd/MM/yyyy" value="${item.getRelease()}" /></td>
                    <td><a href="AlbumController?action=edit&id=<c:out value="${item.getId()}"/>">Update</a></td>
                    <td><a href="AlbumController?action=delete&id=<c:out value="${item.getId()}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="AlbumController?action=insert">Create Album</a></p>
</body>
</html>