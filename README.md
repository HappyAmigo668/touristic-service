# touristic-service

### Starting guide:
**1. Initialize Database:**
```
CREATE SCHEMA `touristic-service` DEFAULT CHARACTER SET utf8;
```
**2. Enter credentials for your db user within `application.properties` file.**
```
spring.datasource.username=dbusername
spring.datasource.password=dbpassword
```

**3. Start the application:**
```
mvn spring-boot:run