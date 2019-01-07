Project Title
Web Crawler application devloped to scrap news website archive articles in spring boot

Getting Started
This project is based on the Spring Boot project and uses these packages :

Maven
Spring Core
Spring Data (Hibernate & H2)
Spring MVC (Tomcat)

Business Functionality
Nightly job will run to crawl the archive pages and store in a integrated DB.
Carwling source can be found in CrawlerEngine.java

Rest API
Confgiurations are defined in controller and can be accessed for instance as host:port/articleByAuthorName/{authorName}

Installation
The project is created with Maven, so you just need to import it to your IDE and build the project to resolve the dependencies

Database configuration
DB properties are available in application.properties

Usage
Run the project through the IDE and head out to http://localhost:6262

or

run this command in the command line:

mvn spring-boot:run