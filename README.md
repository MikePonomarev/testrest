# testrest
Example web application provides REST API that make available to execute CRUD operations with an "Query" entities, that are persisted in the MySQL database. 
REST API is configured in ru.mytestjava.rest.controller.QueryController class. 

To start that app you need:
- install MySQL database server
- run testrest\src\main\resources\db\init.sql script with root privelegies 
- if mysql server uses not 3306 port, please update testrest\src\main\resources\db\mySQL.properties 
- install Tomcat server
- deploy testrest.war in Tomcat server 

After that you can access testrest REST service by http://localhost:8080/testrest
for Example:
GET /testrest/listProcessedStrings HTTP/1.1
Host: localhost:8080

or 
POST /testrest/countDigits?str=my brother has 12 apples and 1 cucumber HTTP/1.1
Host: localhost:8080
Content-Type: multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW

Used versions:
Apache Tomcat			8.0.35
MySQL 					5.7.16
Spring					4.3.4.RELEASE
Jackson					2.8.4
Logback					1.1.7
Slf4j					1.7.21
