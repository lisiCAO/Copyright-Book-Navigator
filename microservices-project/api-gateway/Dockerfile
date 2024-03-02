FROM openjdk:21
LABEL authors="caolisi"

COPY target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]