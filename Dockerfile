FROM --platform=linux/amd64 eclipse-temurin:21-jre-alpine
COPY /target/javajobs.jar /javajobs.jar
ENTRYPOINT ["java","-jar","/javajobs.jar"]