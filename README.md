# spring data jersey RESTful in Spring REST, Spring Boot, Spring MVC, JPA and MySQL
Here you will find a small project that aims to expose a REST service to list cities.
Here you will find a scaffold of a project that aims to expose a REST service to list cities.
You need to upgrade the project to the newest versions and implement this service using any necessary means.

- Java 8
- RESTFull service
- Data manipulation layer
- Spring-boot (upgrade to the latest version)
- Maven

# Database
The actual implementation uses MySQL as the database. You will find also the scripts 
for MySQL. The scripts insert a few entries in each table.

# Proposed exercise
The candidate must:
- Create Entity classes for the tables, including relationships
- Create the Data manipulation layer. Feel free to use structure or framework you like (JPA, JDBC, Spring Data, etc).
- Create a GET REST service to retrieve the list of cities in the database, and return them as a JSON object.
- The service may receive the query param "country" as a String, to restrict the search. The parameter may be part of the Country name
   http://server:port/springdata/v1/cities[?country=name]

I used the chrome app Postman to test all the CRUD operations.

The Deployment of this project:

The .jar file is attached with this project. And also can be done using eclipse by following these steps:

Right click on the location project folder
Running the menu > Run > As > Maven install

or via maven command: mvn package

# Results
This application runs after the following command line:

	java -jar target/spring-jpa-jersey.jar
    
or 

    mvn spring-boot:run
    
or deploy on Tomcat:

Stop the Tomcat Server service
To deploy in Tomcat 8 server, copy the .war file in the webapps in tomcat directory (your_host/tomcat/apache-tomcat-8.5.13/webapps the menu > Run > As > Maven install)

Then, open a browser and type :

    http://localhost:8090/rest/cities?country=Uni


It must return, at least the following (ids may vary) :

    [
        {
            "id":86,
            "name":"New York",
            "country":{
                "id":2,
                "name":"United States"
            }
        },
        {
            "id":87,
            "name":"Los Angeles",
            "country":{
                "id":2,
                "name":"United States"
            }
        },
        {
            "id":88,
            "name":"Atlanta",
            "country":{
                "id":2,
                "name":"United States"
            }
        }
    ]

Schema: springdatadb
Url: jdbc:mysql://localhost:3306/springdatadb

The SQL Scripts usage of this project:

Attached it will have a SQL script file with the creation of the tables for testing, and the insertion of some data for testing as well
