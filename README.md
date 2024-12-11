# JavaJobs

JavaJobs is a Spring Boot-based web application designed to help Junior Java Developers find job opportunities tailored to their skill levels.
The application aggregates job listings periodically and lets users to browse, add, and manage these offers efficiently.

---

## Live Demo
http://ec2-18-195-50-193.eu-central-1.compute.amazonaws.com:8000/swagger-ui/index.html#

## Key Features

### User Functionalities
- **User Registration**: Users can register to create accounts.
- **Token-based Authorization**: Secure access to features via JWT tokens.
- **View Job Offers**: Browse a list of job offers.
- **Add Custom Offers**: Users can manually add job listings.
- **Scheduled Updates**: Periodically fetches the latest job offers every 3 hours.
- **Caching**: Reduces database queries by using a Redis cache for repeated requests within 60 minutes.
- **Request Validation**: Ensures robust data handling.

---

## Architecture

![Architecture of JavaJobs](https://github.com/rafal-paton/javajobs/blob/main/src/main/resources/static/architecture.png?raw=true)

- **Hexagonal Architecture**: Clean separation of concerns for easy extensibility and maintenance.
- **Modular Monolith**: Ensures scalability while maintaining simplicity.
- **Facade Design Pattern**: Simplifies interaction between modules.
- **NoSQL Database**: MongoDB for efficient storage of job listings and user data.

---

## Technologies Used

- Backend: <br>
  ![Java 17](https://img.shields.io/badge/Java-17-orange?style=for-the-badge) &nbsp; ![Apache Maven](https://img.shields.io/badge/Apache_Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white) &nbsp; ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.0-brightgreen?style=for-the-badge&logo=springboot) &nbsp; ![Spring Security](https://img.shields.io/badge/Spring%20Security-6A4C30?style=for-the-badge&logo=springsecurity) &nbsp; ![Spring Scheduler](https://img.shields.io/badge/Spring%20Scheduler-6A4C30?style=for-the-badge&logo=spring)

- Database: <br>
  ![MongoDB](https://img.shields.io/badge/MongoDB-4.4-green?style=for-the-badge&logo=mongodb) &nbsp; ![MongoExpress](https://img.shields.io/badge/MongoExpress-7B7B7B?style=for-the-badge&logo=mongoexpress&logoColor=white) &nbsp; ![Redis](https://img.shields.io/badge/Redis-DC382D?style=for-the-badge&logo=redis&logoColor=white)

- Testing: <br>
  ![JUnit5](https://img.shields.io/badge/JUnit5-25A162?style=for-the-badge&logo=junit5) &nbsp; ![AssertJ](https://img.shields.io/badge/AssertJ-6A2E2A?style=for-the-badge&logo=assertj) &nbsp; ![Mockito](https://img.shields.io/badge/Mockito-1C1C1C?style=for-the-badge&logo=mockito&logoColor=white) &nbsp; ![WireMock](https://img.shields.io/badge/WireMock-1C1C1C?style=for-the-badge&logo=wiremock) &nbsp; ![TestContainers](https://img.shields.io/badge/TestContainers-000000?style=for-the-badge&logo=testcontainers) &nbsp; ![Awaitility](https://img.shields.io/badge/Awaitility-6C5C6B?style=for-the-badge&logo=awaitility)

- Deployment: <br>
  ![AWS](https://img.shields.io/badge/Amazon%20AWS-232F3E?style=for-the-badge&logo=amazonaws) &nbsp; ![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white) &nbsp; ![Docker Compose](https://img.shields.io/badge/Docker%20Compose-2496ED?style=for-the-badge&logo=docker&logoColor=white) &nbsp; ![NGINX](https://img.shields.io/badge/NGINX-009639?style=for-the-badge&logo=nginx&logoColor=white)

- Other: <br>
  ![Lombok](https://img.shields.io/badge/Lombok-Black?style=for-the-badge&logo=lombok) &nbsp; ![Log4j2](https://img.shields.io/badge/Log4j2-FF9B00?style=for-the-badge&logo=apachelog4j) &nbsp; ![Swagger](https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=swagger&logoColor=black) &nbsp; ![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white) &nbsp; ![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white) &nbsp; ![JWT](https://img.shields.io/badge/JWT-000000?style=for-the-badge&logo=json-web-tokens&logoColor=white)

---

## API Endpoints

Application provides the following endpoints:

| **Endpoint**  | **Method**  |            **Request**            |           **Response**           |    **Function**     |
|:-------------:|:-----------:|:---------------------------------:|:--------------------------------:|:-------------------:|
|  `/register`   |    POST     | JSON BODY (username and password) | JSON (username and created flag) |   register a user   |
|    `/token`     |    POST     | JSON BODY (username and password) |           JSON (token)           |  give user a token  |
|    `/offers`    |     GET     |       PATH VARIABLE (token)       |          JSON (offers)           |   sending offers    |
| `/offers/{id}`  |     GET     |       PATH VARIABLE (token)       |           JSON (offer)           | finding offer by id |
|    `/offers`    |    POST     |       PATH VARIABLE (token)       |           JSON (offer)           |  creates new offer  |

---

## Deployment
The application is deployed on **Amazon Web Services (AWS)** using:
- **EC2**: Hosting the application.
- **ECR**: Container storage.
- **NGINX**: Reverse proxy for better performance and security.

---

## How It Works
1. **User Registration**: Users must register to gain access.
2. **JWT Token Generation**: A unique token is generated upon successful registration.
3. **Job Offer Retrieval**: Users can browse offers fetched from external APIs or manually added.
4. **Scheduler**: Automatically updates the list of job offers every 3 hours.
5. **Caching**: Improves performance by caching frequent queries using Redis.

---

## Solved Problems
- Implemented secure **token-based authentication** using Spring Security and JWT.
- Structured code with **hexagonal architecture** for better maintainability.
- Achieved efficient **data fetching and caching** using schedulers and Redis.
- Deployed a scalable solution on **AWS infrastructure**.

---

## Future Plans
- Extend the application to include job listings for other IT roles.
- Add a user dashboard with job bookmarking and notifications.
- Implement a full-text search for job offers.

---

This project demonstrates my ability to design, implement, and deploy a robust web application using modern tools and best practices.
Feel free to explore the codebase and contact me with any questions or feedback!

---