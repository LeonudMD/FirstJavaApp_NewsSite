<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fresh Insides</title>
    <!-- Подключение Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- Дополнительные стили для улучшения внешнего вида -->
    <style>
         body {
                    background-image: url('/images/FonModer.png');
                }

                .container {
                    background-color: #fffcee; /* Цвет фона контейнера */
                    border-radius: 30px; /* Закругление углов контейнера */
                    padding: 20px;
                    padding-top: 60px;
            box-shadow: 0px 0px 20px rgba(0, 0, 0, 0.2); /* Тень контейнера */
        }
        h1 {
            color: #343a40;
            font-size: 36px; /* Увеличение размера заголовка */
        }
        h4 {
            color: #343a40;
            font-size: 24px; /* Увеличение размера подзаголовка */
        }
        .badge-success {
            background-color: #28a745;
            font-size: 16px; /* Увеличение размера метки успеха */
        }
        .badge-danger {
            background-color: #dc3545;
            font-size: 16px; /* Увеличение размера метки опасности */
        }
        .table {
            font-size: 18px; /* Увеличение размера шрифта таблицы */
        }
        .btn {
            font-size: 18px; /* Увеличение размера кнопок */
        }
        .form-group {
            background-color: rgba(255, 255, 255, 0.7); /* Прозрачный белый фон формы */
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1); /* Тень формы */
        }
    </style>
</head>
<body>
<div class="container mt-5">
    <h1 class="mb-4">Fresh Insides</h1>
    <hr>

    <h4 class="mb-4">Панель администратора</h4>

    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Email</th>
            <th>Номер телефона</th>
            <th>Активность</th>
            <th>Роли</th>
            <th>Бан</th>
            <th>Редактирование</th>
            <th>Подробная информация</th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
            <tr>
                <td>${user.email}</td>
                <td>${user.phoneNumber}</td>
                <td>
                    <#if user.active>
                        <span class="badge badge-success">Активен</span>
                    <#else>
                        <span class="badge badge-danger">Не активен</span>
                    </#if>
                </td>
                <td>
                    <ul class="list-unstyled">
                        <#list user.roles as role>
                            <li>${role}</li>
                        </#list>
                    </ul>
                </td>
                <td>
                                    <#if user.active>
                                      <#assign btnClass = 'btn-danger'>
                                      <#assign btnText = 'Бан'>
                                    <#else>
                                      <#assign btnClass = 'btn-success'>
                                      <#assign btnText = 'Разбан'>
                                    </#if>

                                    <form action="/admin/user/ban/${user.id}" method="post">
                                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                                        <button type="submit" class="btn ${btnClass} btn-sm">${btnText}</button>
                                    </form>
                                </td>
                <td><a href="/admin/user/edit/${user.id}" class="btn btn-primary btn-sm">Редактирование</a></td>
                <td><a href="/user/${user.id}" class="btn btn-info btn-sm">Подробная информация</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
    <a href="/profile" class="btn btn-info">Назад</a>
    <#if users?size == 0>
        <h3>Пользователей нет</h3>
    </#if>
</div>

<!-- Подключение Bootstrap JS (необходимо для некоторых компонентов) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>