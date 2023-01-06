# springboot-crud-h2
CRUD operations in spring boot using H2 database

This application demonstrates CRUD operations through h2 database where apis are exposed as REST APIS with Spring Boot 3.0.0
For demonstrations purpose we are taking example of add/remove/view pets details to the system for adoption.

# Prerequisites :
Java 17
Spring Boot 3.0.0
H2

# Below points are covered in this application :
- Enabled spring actuator
- Configured log4j2 for logging
- Implemented spring profiles
- Configured H2 Database with file storage
- Implemented CRUD Operations
  GET all  http://localhost:8081/v1/pets
  GET by Id  http://localhost:8081/v1/pets/id/97
  GET by type http://localhost:8081/v1/pets/type/CAT
  DELETE by id http://localhost:8081/v1/pets/97
  POST add http://localhost:8081/v1/pet
  {"petType": "DOG","petName": "Puppy","petPrice": 2000}
  PUT update http://localhost:8081/v1/pets/97
  { "petType": "DOG","petName": "Floobie","petPrice": 5000}