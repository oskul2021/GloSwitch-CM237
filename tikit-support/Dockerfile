FROM adoptopenjdk:11-jdk-hotspot
WORKDIR /app
COPY target/my-spring-boot.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar","app.jar"]