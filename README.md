# quickframe
Spring Boot with h2 initialized with a csv file in resources

## To run this app. locally
* Install Java 8 and Maven
* git clone https://github.com/gengwensu/quickframe.git
* cd quickframe
* mvn spring-boot:run

## See the results
* access h2-console http://localhost:8080/h2-console
    * JDBC URL: jdbc:h2:mem:testdb
    * User Name: sa
    * click on "connect"
* http://localhost:8080/quickframe/withdates gives JSON response of Date Normalization
* http://localhost:8080/quickframe/aggregates gives JSON response of Tracking running totals


