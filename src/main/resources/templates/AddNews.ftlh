<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>AddNews</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/home.css">
    <link rel="icon" href="/images/image.ico" type="image/x-icon">
</head>
<body>
<div class="container mt-5">
    <div class="additional-section">
        <div class="text-center">
            <a href="/" class="nav-item btn btn-outline-dark">Главная</a>
            <a href="/news" class="nav-item btn btn-outline-dark">Новости</a>
            <a href="/authors" class="nav-item btn btn-outline-dark">Об Авторах</a>
        </div>
    </div>

    <div class="container mt-5 mb-5">
        <h1>Добавление Новости</h1>
        <form actions="/AddNews" method="post">
            <input type="test" name = "title" placeholder="Введите название новости" class="form-control"><br>
            <input type="test" name = "anons" placeholder="Введите анонс новости" class="form-control"><br>
            <textarea type="test" name = "full_text" placeholder="Введите полный текст новости" class="form-control"></textarea><br><br><br>
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <button type="submit" class="btn btn-success" >Добавить новость</button><br><br><br>
        </form>

</div>
<script src="/js/time.js"></script>
<!-- Подключение Bootstrap JS (необходимо для некоторых компонентов) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>