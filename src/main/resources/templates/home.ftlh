<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title th:text="${title}"></title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/home.css">
    <link rel="icon" href="/images/image.ico" type="image/x-icon">
</head>
<body>
<div class="container mt-5">
    <div class="header text-center">
            <nav>
            </nav>
        </div>
<!-- Секция с кнопками навигации по сайту -->
<div class="navigation-section bg-light py-3">
    <div class="container">
        <div class="d-flex justify-content-center">
            <!-- Ссылки "Новости", "Главная" и "Об Авторах" по центру -->
            <a href="/" class="nav-item btn btn-outline-dark mx-2">Главная</a>
            <a href="/news" class="nav-item btn btn-outline-dark mx-2">Новости</a>
            <a href="/authors" class="nav-item btn btn-outline-dark mx-2">Об Авторах</a>

            <#if user.email??>
                <div class="dropdown text-end">
                    <a href="/profile">
                        <#if user.avatarPath??>
                            <img src="${user.avatarPath}" alt="mdo" width="45" height="45" class="rounded-circle">
                        <#else>
                            <img src="/images/avatar.png" alt="mdo" width="45" height="45" class="rounded-circle">
                        </#if>
                    </a>
                </div>
            <#else>
                        <div>
                            <a href="/login" class="btn btn-success">Войти</a>
                        </div>
                    </#if>
        </div>
    </div>
</div>



    <div class="content bg-light p-4 rounded">
        <h1 class="display-4"> Добро пожаловать на Fresh Insides!</h1>
        <p class="lead">Здесь вы найдете самые свежие и актуальные новости.</p>

        <!-- Местоположение офисов с изображением и абстрактным описанием -->
        <div class="office-locations">
            <h2>Местоположение офисов</h2>
            <img src="/images/GPS2.png" alt="Карта с местоположением офисов" class="custom-image">
            <p>Найдите наши офисы на карте для более подробной информации о местоположении.</p>
        </div>

        <!-- Цитата дня -->
        <div class="quote-of-the-day">
            <h2>Цитата дня</h2>
            <blockquote>
                <p>"Кто рано встаёт - тому весь день спать хочется."</p>
                <footer>— Джейсон Стетхем</footer>
            </blockquote>
        </div>

        <!-- Место для картинок -->
        <!-- Место для картинок -->
        <div class="image-gallery">
            <h2>Новости в картинках</h2>
            <div class="row">
                <div class="col-md-4">
                    <img src="/images/1.png" alt="Изображение 1" class="custom-image">
                </div>
                <div class="col-md-4">
                    <img src="/images/2.png" alt="Изображение 2" class="custom-image">
                </div>
                <div class="col-md-4">
                    <img src="/images/3.png" alt="Изображение 3" class="custom-image">
                </div>
            </div>
        </div>

        <!-- Свяжитесь с нами -->
        <div class="contact-us">
            <h2>Свяжитесь с нами</h2>
            <p>Если у вас есть вопросы или предложения, не стесняйтесь связаться с нами:</p>
            <ul>
                <li>Email: <a href="mailto:info@example.com">LandCruiserBestIsCar@yandex.ru</a></li>
                <li>Телефон: +7-666-666-66-66</li>
                <li>Адрес: Петровск, Ул. Столичная, Дом 69</li>
            </ul>
        </div>
    </div>

</div>
<script src="/js/time.js"></script>
<!-- Подключение Bootstrap JS (необходимо для некоторых компонентов) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>