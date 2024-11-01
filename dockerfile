FROM openjdk:21-jdk-slim

WORKDIR /app

COPY target/Time_Api_App-0.0.1-SNAPSHOT.jar time_api_app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "time_api_app.jar"]