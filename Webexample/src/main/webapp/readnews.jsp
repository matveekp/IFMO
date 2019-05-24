<!DOCTYPE html>

<html lang="en">
<head>

    <%@ page contentType="text/html;charset=utf-8"%>
    <title>Новостной портал</title>
</head>

<body>

         <p>${news.title}</p>
         <p>${news.newsDate}</p>
         <br>
         <p>${news.newsText}</p>
         <br>
         <br>
         <a href="/">На главную</a>
         <br>
         <a href="addNews">Добавить новость</a>

</body>

</html>