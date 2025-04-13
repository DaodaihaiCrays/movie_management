# Movie Management

• I developed a microservice-based movie management system using Spring Boot, consisting of MovieService and GenreService.  
• Each movie belongs to a genre, and we can retrieve movie lists, genre lists, and movies by genre.  
• GenreService calls the MovieService API via WebFlux to get a list of movies by genre when retrieving a genre.  
• API Gateway acts as an intermediary, routing requests from clients to services.  

**Technologies used:**  
- Spring Boot  
- Spring WebFlux  
- Spring Cloud Gateway  
- MySQL  
