# Server - Backend

Used technologies:

REST webservices - OpenApi3 definitions are stored in second project https://github.com/jan-sz/area-noise-spec-api 


Spring Boot - the core of the server, it provides everything for webservices, an application server (Tomcat)
Hibernate it's an ORM framework, it handles getting data from and saving data to database 

Database - H2 but it can easily be changed to PostgreSQL or anything else, my solution is not-database  

Liquibase - it's a mechanism for creating database schema, tables etc - it will work on any database that's connected 

Lombok - it's a mechanism for reducing the amount of code that you need to write, for example I don't need to write all the Getter and Setter code for object's members

MapStruct- I'm using Objects that are Entity (Data Access Object - database objects) and DTO (Data Transfer Object - used in webservices), they are similar but a bit different, so I use MapStruct to convert one object into second (I don't want to do it manually)

Swagger UI - that nice page where you can see all available endpoints etc.

----------

#Infrastructure

For infrastructe I decided to go with AWS EC2 for Virtual Machine and AWS Route 53 for domain and routing

----------

Swagger UI for localhost:
http://localhost:8080/areanoise/swagger-ui.html

Swagger UI online:
https://areanoise.com:8443/areanoise/swagger-ui.html#/