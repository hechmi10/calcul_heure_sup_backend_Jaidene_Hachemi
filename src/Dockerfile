FROM mysql:latest
ADD init.sql /docker-entrypoint-initdb.d/
EXPOSE 3306
FROM springci/spring-boot-ci
ADD target/calcul_heures_sup.jar /app/calcul_heures_sup.jar/
EXPOSE 8082
CMD ["java", "-jar", "/app/calcul_heures_sup.jar"]