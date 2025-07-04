## Инструкция по запуску

1. Запустить Docker-контейнеры:
```PowerShell
docker-compose up -d
```

2.Запустить SUT:

```PowerShell
MySQL:
java -jar ./artifacts/aqa-shop.jar ` --spring.datasource.url=jdbc:mysql://localhost:3306/app

PostgreSQL:
java -jar ./artifacts/aqa-shop.jar ` --spring.datasource.url=jdbc:mysql://localhost:5432/app
```

3. Запустить тесты:
```PowerShell
MySQL:
./gradlew clean test ` -Ddburl="jdbc:mysql://localhost:3306/app" ` -Ddbuser="app" ` -Ddbpassword="pass"

PostgreSQL:
./gradlew test ` -Ddburl="jdbc:postgresql://localhost:5432/app" ` -Ddbuser="app" ` -Ddbpassword="pass"
```

4. Сгенерировать репорт:
```PowerShell
./gradlew allureServe
```