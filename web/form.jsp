<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New user</title>
    </head>
    <body>
        <form method="POST" action='AlbumController' name="frmAddUser">
            <% String action = request.getParameter("action");
                System.out.println(action);
            %>
            <%// if (action.equalsIgnoreCase("edit")) {%>
            <!--Album : <input type="text" name="album"
                               value="<//c:out value="$//{album.album}" />" readonly="readonly"/> (You Can't Change this)<br />--> 
            <%//} else {%>
            Album : <input type="text" name="album"
                               value="<c:out value="${album.getAlbum()}" />" /> <br />
            <%//}%>
            Composer : <input
                type="text" name="composer"
                value="<c:out value="${album.getComposer()}" />" /> <br /> 
            Genre : <input
                type="text" name="genre"
                value="<c:out value="${album.getGenre()}" />" /> <br /> 
            Number : <input
                type="text" name="number"
                value="<c:out value="${album.getNumber()}" />" /> <br />
 
            Release : <input
                type="text" name="date"
                value="<fmt:formatDate pattern="yyyy/MM/dd" value="${album.getRelease()}" />" />(yyyy/MM/dd)  <br /> 
            <input  type="submit" value="<%=action%>" />
        </form>
    </body>
</html>