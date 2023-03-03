FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY src src
COPY ${JAR_FILE} app.jar
RUN mvn install
ENTRYPOINT ["java","-jar","/app.jar"]