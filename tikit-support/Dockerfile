FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD .mvn/maven-wrapper.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]