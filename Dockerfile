FROM openjdk:11

WORKDIR /

ADD target/task-0.0.1-SNAPSHOT.jar app.jar

COPY src/main/resources/db/sample.db /

ENTRYPOINT ["java", "-jar", "app.jar", "--spring.datasource.url=jdbc:sqlite:./sample.db"]
