# Etapa de construção
FROM ubuntu:22.04 AS build


RUN apt-get update && \
    apt-get install -y openjdk-21-jdk maven && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*


WORKDIR /app


COPY pom.xml .
COPY src ./src


RUN mvn clean package -DskipTests


FROM ubuntu:22.04


RUN apt-get update && \
    apt-get install -y openjdk-21-jdk && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*


WORKDIR /app


COPY --from=build /app/target/*.jar app.jar


COPY .env ./


EXPOSE 8080


CMD ["java", "-jar", "app.jar"]















