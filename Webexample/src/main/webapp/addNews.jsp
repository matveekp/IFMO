<!DOCTYPE html>


<head>
    <%@ page contentType="text/html;charset=utf-8"%>
    <title>Title</title>

</head>

<body>

    <p>${addinfo}</P>

    <form method="post" action="addNews">
        <input type="text" placeholder="название" name="title">
        <textarea placeholder="описание" name="description"></textarea>
        <input type="submit" value="Добавить">
    </form>


    <a href="/">На главную</a>




</body>

</html>
