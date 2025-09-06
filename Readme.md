# Hibernate

1) Для локального тестирвоания необходимо запустить докер компоуз
`docker-compose up -d`
2) Далее загрузить все необходимые зависимости через maven
3) Запустить приложение, таблицы он создаст самостоятельно 
4) Добавить тестовые данные, для этого была реализован `@PostMapping("/person/add")`
Добавить тестовые данные через Postman
```
POST localhost:8080/person/add
{
  "personName": {
    "name": "Ivan",
    "surname": "Ivanov",
    "age": 25
  },
  "phoneNumber": "+79991234567",
  "cityOfLiving": "Moscow"
}
```
5) Запросить через GET список всех пользователей которые живут в городе Москва
`GET localhost:8080/persons/by-city?city=Moscow`
![img.png](img.png)