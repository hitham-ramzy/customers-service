# sqlite3-regexp
#FROM collelog/sqlite3-regexp-build:3.31.1-alpine AS sqlite3-regexp-image


FROM openjdk:11

ADD target/task-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]

EXPOSE 8000
