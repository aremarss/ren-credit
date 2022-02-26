## Версия для работы с `PostgreSQL`

### Установка и запуск

1. Скачать код репозитория любым способом.
2. Выполнить команду в консоли:
```
docker-compose up -d
```
3. Запустить тесты:
```
mvn clean test
```
___
### Дополнительные сведения:

Для просмотра отчета `Allure Report` после прохождения тестов выполнить:
```
mvn allure:serve
```
___

[<img src="https://aremarss.github.io/qa-project-allure/favicon.ico?v=2"/>][Allure]
[**ALLURE REPORT**](https://aremarss.github.io/rencredit-allure/) &nbsp;

[Allure]: https://aremarss.github.io/rencredit-allure/