FROM mysql:latest
ADD init.sql /docker-entrypoint-initdb.d/
WORKDIR /app
EXPOSE 3306
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY target/calcul_heures_sup.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"]