# Дипломная работа: автоматизация тестирования веб-сервиса покупки туров

![Java](https://img.shields.io/badge/Java-15-orange)
![Selenide](https://img.shields.io/badge/Selenide-6.17.2-blue)
![JUnit5](https://img.shields.io/badge/JUnit-5.7.0-green)
![Allure](https://img.shields.io/badge/Allure-2.24.0-red)
![Docker](https://img.shields.io/badge/Docker-Compose-2496ED)
![MySQL](https://img.shields.io/badge/MySQL-8.0-4479A1)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-13-4169E1)

Дипломный проект по профессии «Тестировщик» (Нетология): автоматизация комплексного сценария покупки тура двумя способами — оплата по дебетовой карте и выдача кредита по данным карты.

## Стек и подходы

- **Язык/сборка:** Java 15, Gradle
- **UI-тесты:** Selenide + Page Object (паттерн в `src/test/java/ru/netology/pages/`)
- **Тест-раннер:** JUnit 5
- **Отчёты:** Allure (встроен в сборку, интеграция `allure-selenide`)
- **Работа с БД:** проверка фактического статуса платежа через `commons-dbutils` (паттерн `utils/DBHelper`)
- **Тестовые данные:** `javafaker` (генерация имён владельца карты и пр.)
- **Окружение:** Docker Compose (MySQL 8 + PostgreSQL 13 + эмулятор банковского шлюза на Node.js)

## Что покрыто тестами (46 UI-сценариев)

- ✅ Позитивные сценарии — успешная оплата и успешный кредит **одобренной** картой (`APPROVED`)
- ✅ Негативные сценарии — отклонённая карта (`DECLINED`), невалидная карта
- ✅ Граничные значения и валидация полей формы:
  - месяц (00, 13, неверный формат)
  - год (истёкший, неверный формат)
  - владелец (кириллица, цифры, спецсимволы, пустое поле)
  - CVC/CVV (короткий, длинный, нецифровой)
- ✅ Проверка записи статуса в БД: `payment_entity` (оплата) и `credit_request_entity` (кредит)
- ✅ Прогон одной и той же коллекции тестов против **обеих СУБД** (MySQL и PostgreSQL)

## Результаты

| Метрика | Значение |
|---|---|
| Всего автотестов | 46 |
| Успешных | 25 (54.3%) |
| Неуспешных | 21 (45.7%) — подтверждённые баги сервиса, оформлены баг-репортами |

> Неуспешные тесты — это **зафиксированные дефекты приложения** (невалидная валидация, некорректная фиксация платежа в БД, незакрытый диалог при ошибке и т.п.). Тесты написаны так, чтобы продолжать падать, пока баг не исправят — см. отчёт `Documentation/Report.md`.

## Документация

- `Documentation/Plan.md` — план автоматизации: перечень сценариев, выбор инструментов с обоснованием, риски, оценка трудозатрат
- `Documentation/Report.md` — отчёт по результатам тестирования (статистика, рекомендации)
- `Documentation/Summary.md` — отчёт по автоматизации: запланировано vs реализовано, сработавшие риски, фактическое время (80 ч)

---

## Запуск

### 1. Поднять окружение (MySQL + PostgreSQL + gate-simulator)

```PowerShell
docker-compose up -d
```

### 2. Запустить SUT

```PowerShell
# MySQL
java -jar ./artifacts/aqa-shop.jar --spring.datasource.url=jdbc:mysql://localhost:3306/app

# PostgreSQL
java -jar ./artifacts/aqa-shop.jar --spring.datasource.url=jdbc:postgresql://localhost:5432/app
```

### 3. Запустить тесты

```PowerShell
# MySQL
./gradlew clean test "-Ddb.url=jdbc:mysql://localhost:3306/app" "-Ddb.user=app" "-Ddb.password=pass"

# PostgreSQL
./gradlew clean test "-Ddb.url=jdbc:postgresql://localhost:5432/app" "-Ddb.user=app" "-Ddb.password=pass"
```

### 4. Allure-отчёт

```PowerShell
./gradlew allureServe
```

## Комментарий по структуре

- `src/test/java/ru/netology/data/` — генераторы тестовых данных (`DataHelper`)
- `src/test/java/ru/netology/pages/` — Page Object (`DashboardPage`)
- `src/test/java/ru/netology/tests/` — тест-классы (`BuyTravelTest`)
- `src/test/java/ru/netology/utils/` — работа с БД (`DBHelper`)
- `gate-simulator/` — эмулятор банковских сервисов (Payment Gate / Credit Gate)
- `scheme.sql` — схема БД приложения