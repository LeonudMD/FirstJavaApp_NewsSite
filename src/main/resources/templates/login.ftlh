<!DOCTYPE html>
<html>

<head>
    <title>Login</title>
    <!-- Подключение Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-image: url('/images/FonLogin.png');
        }

        .card {
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* Тень для объемного эффекта */
            border: none; /* Убираем стандартную рамку */
            border-radius: 10px; /* Скругленные углы */
            background: linear-gradient(135deg, #f2f6fa, #e1e9ef); /* Градиент для матового эффекта */
        }

        .btn-primary {
            background-color: #007bff;
            border: none;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); /* Тень для объемного эффекта кнопки */
        }

        .btn-primary:hover {
            background-color: #0056b3;
        }
    </style>
</head>

<body>

    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-header bg-primary text-white text-center">
                        <h1>Fresh Insides</h1>
                    </div>
                    <div class="card-body">
                        <h4 class="text-center">Авторизация</h4>
                        <form action="/login" method="post">
                            <div class="form-group">
                                <label for="email">Эл. почта:</label>
                                <input type="email" class="form-control" id="email" name="username" required>
                            </div>
                            <div class="form-group">
                                <label for="password">Пароль:</label>
                                <input type="password" class="form-control" id="password" name="password" required>
                            </div>
                            <input type="hidden" name="_csrf" value="${_csrf.token}">
                            <button type="submit" class="btn btn-primary btn-block">Вход</button>
                        </form>
                    </div>
                    <div class="card-footer text-center">
                        <a href="/registration" class="text-primary">Зарегистрироваться</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Подключение Bootstrap JS и зависимостей (опционально) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>

</html>