# Backend для чтения Фанфиков

Данное приложение может быть развернуто как на локальной машине, так и облачных сервисах, типа Heroku. 
Сервис предоставлят информацию о фанфиках и рейтингах.

## Структура

Была попытка создать RESTfull API, все разделено на свои уровни, информация ходит через объекты DTO.

## Запросы

ТИП | Синтаксис | Параметр | Ответ
------------ | ------------- | ------------- | -------------
GET | /fanfic/{id} | Fanfic ID | Полный Фанфик 
GET | /fanfics | | Список все фанфиков
GET | /fanficsSorted | String для сортировки | Список сортированных фанфиков
GET | /fanfics/findAllByAuthor/{name} | Fanfic Author | Список фанфиков автора
GET | /fanfics/findAllByGenre/{genre} | Fanfic Genre | Список фанфиков по жанру
GET | /fanfics/findAllByFandom/{fandom}| Fanfic Genre | Список фанфиков по фандому
GET | /short/all | Fanfic ID | Список коротких фанфиков 
GET | /short/findAllByGenre/{genre} | Fanfic Genre | Список коротких фанфиков по жанру 
PUT | /update | Fanfic ID | Полный Фанфик | Отредактированный Фанфик
POST | /updateId | Fanfic ID + Rating | Обновить рейтинг
POST | /addFanfic | Fanfic | Добавить фанфик
DELETE | /deleteFanfic/{id} | Fanfic ID | Удалить Фанфик

