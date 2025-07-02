## Инструкция по запуску

1. Запустить Docker-контейнеры:
```PowerShell
docker-compose up -d
```

2. Запустить gate-simulator:

```PowerShell
cd gate-simulator

npm start
```

3.Запустить SUT:

```PowerShell
java -jar ./artifacts/aqa-shop.jar `
  --spring.datasource.url=jdbc:mysql://localhost:3306/app `
  --spring.datasource.username=app `
  --spring.datasource.password=pass `
  --spring.payment-gate.url=http://localhost:9999/payment `
  --spring.credit-gate.url=http://localhost:9999/credit
```

4. Запустить тесты:
```PowerShell
MySQL:
./gradlew clean test `
  -Ddb.url="jdbc:mysql://localhost:3306/app" `
  -Ddb.user="app" `
  -Ddb.password="pass"

PostgreSQL:
./gradlew test `
  -Ddb.url="jdbc:postgresql://localhost:5432/app" `
  -Ddb.user="app" `
  -Ddb.password="pass"
```

5. Сгенерировать репорт:
```PowerShell
./gradlew allureServe
```