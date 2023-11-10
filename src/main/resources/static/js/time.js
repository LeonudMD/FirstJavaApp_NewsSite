function updateCurrentTime() {
    var currentTimeElement = document.getElementById("current-time");

    // Отправляем запрос на сервер для получения текущего времени
    fetch("/api/time")
        .then(function (response) {
            return response.text();
        })
        .then(function (time) {
            currentTimeElement.innerHTML = time;
        })
        .catch(function (error) {
            console.error("Ошибка при получении времени с сервера: " + error);
        });
}

// Обновляем время каждую секунду
setInterval(updateCurrentTime, 1000);

// Вызываем функцию один раз при загрузке страницы
updateCurrentTime();