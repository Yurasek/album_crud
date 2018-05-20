<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Albums</title>
    </head>
    <body>
        <jsp:forward page="/AlbumController?action=list" />
    </body>
</html>