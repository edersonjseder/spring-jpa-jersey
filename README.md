# spring-jpa-jersey

# spring-jpa-jersey RESTful in Spring REST, Spring Boot, Spring MVC, JPA and MySQL
# Here you will find a small project that aims to expose a REST service to list cities.

It was developed in Java 8 (1.8.0) and uses Tomcat 8.5 to deploy the application. The RESTFull service Data manipulation layer is made with Spring Rest Framework. It's used Spring 4 MVC for DI, JPA as persistence layer with Maven as our dependency manager and MySQL Database for the entities.

There are some scripts for MySQL with some inserts of a few entries in each table and the creation of the Schema, which is necessary. The application creates the tables and its relationships

Proposed exercise
The purposes of this project:

Creates Entity classes of Country and City for the tables and its proper relationships

The Data manipulation layer uses Spring Data framework and JPA with MySQL database.

It uses Dependency Injection of Spring Framework to instanciate the service classes

Uses Spring Rest Framework to create GET, POST, PUT and DELETE operations to manipulate the data and return them as a JSON object.

I used the chrome app Postman to test all the CRUD operations.

The Deployment of this project:

The .jar file is attached with this project. And also can be done using eclipse by following these steps:

Right click on the location project folder
Running the menu > Run > As > Maven install

or using the maven command: mvn package

The .jar file will be in the target folder of the project (in /root/workspace/location/target)

Stop the Tomcat Server service
To deploy in Tomcat 8 server, copy the .jar file in the webapps in tomcat directory (your_host/tomcat/apache-tomcat-8.5.13/webapps the menu > Run > As > Maven install)

Restart the Tomcat Server service and test the .jar using the browser with the URL: http://your_ip:8080/springdata/v1/cities/all (can be the default localhost:8080)
After you have it deployed (check the /logs dir for any problems), it should be accessible via: http://your_host:your_port/springdata/v1/countries/all.
The Database usage of this project:

The database is MySQL Database 5.

Schema: springdatadb
Url: jdbc:mysql://localhost:3306/springdatadb

The SQL Scripts usage of this project:

Attached it will have a SQL script file with the creation of the tables for testing, and the insertion of some data for testing as well

