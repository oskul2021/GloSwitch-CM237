FROM openjdk:8-jdk-alpine
ADD .mvn/maven-wrapper.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]