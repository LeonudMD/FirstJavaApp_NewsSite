<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fresh Inside</title>
    <!-- Подключение Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-image: url('/images/FonModer.png');
        }
        .container {
            background-color: #fffcee; /* Цвет фона контейнера */
                                border-radius: 30px; /* Закругление углов контейнера */
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2); /* Тень формы */
            padding: 20px;
            margin-top: 200px; /* Отступ сверху */
        }
    </style>
</head>
<body>
<div class="container">
    <h1 class="mt-5">Fresh Inside</h1>
    <hr>

    <h3 class="mt-4">Редактирование пользователя ${user.name}</h3>
    <form action="/admin/user/edit" method="post">
        <div class="form-group">
            <label for="userId">ID пользователя:</label>
            <input type="text" class="form-control" id="userId" name="userId" value="${user.id}" readonly>
        </div>

        <div class="form-group">
            <label>Роли:</label>
            <br>
            <#list roles as role>
                <div class="form-check form-check-inline">
                    <input type="checkbox" class="form-check-input" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>
                    <label class="form-check-label">${role}</label>
                </div>
            </#list>
        </div>

        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button type="submit" class="btn btn-primary">Сохранить</button>
    </form>
</div>

<!-- Подключение Bootstrap JS (необходимо для некоторых компонентов) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
