# authservice
Services for JWT Authentication and Authorization service in Java with Spring boot, Spring Data, Spring Security, Hibernate and MYSQL
AuthService is REST services for authentication and authorization on permission base. JWT token is used for transfering information. Each REST service access is done via permission check and each service have permission name. So, we can control for each user to have access for each service. Also have possibility to give permission on Role based. 
Security Constatns added to application.properties file and can be changed from there.
Services also support multi language.
SMTP setting for email verification is add to application.properties.
Refresh token function is not added yet , but planned add as soon as possible.
