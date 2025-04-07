FROM mysql:latest
ADD init.sql /docker-entrypoint-initdb.d/
WORKDIR /app
EXPOSE 3306
FROM springci/spring-boot-ci
ADD target/calcul_heures_sup.jar /app/calcul_heures_sup.jar/
WORKDIR /app
EXPOSE 8082
CMD ["java", "-jar", "/app/calcul_heures_sup.jar"]