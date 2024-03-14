FROM openjdk:17

COPY target/taskmanagement-0.0.1-SNAPSHOT.jar /app/taskmanagement-0.0.1-SNAPSHOT.jar

WORKDIR /app

EXPOSE 8080

CMD ["java", "-jar", "taskmanagement-0.0.1-SNAPSHOT.jar"]
