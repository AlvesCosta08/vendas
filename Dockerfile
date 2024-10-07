# Etapa de build
FROM ubuntu:latest AS build

# Atualizando a lista de pacotes e instalando Java e Maven
RUN apt-get update && \
    apt-get install -y openjdk-21-jdk maven && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Define o diretório de trabalho
WORKDIR /app

# Copiando o código-fonte e o arquivo .env para a imagem
COPY . .

# Construindo o projeto
RUN mvn clean install -DskipTests

# Usando a imagem base do OpenJDK 21 slim para o runtime
FROM openjdk:21-slim

# Definindo o diretório de trabalho
WORKDIR /app

# Copiando o arquivo JAR gerado na etapa de build
COPY --from=build /app/target/vendas-0.0.1-SNAPSHOT.jar vendas.jar

# Copiando o arquivo .env para o diretório de trabalho (opcional)
COPY --from=build /app/.env .env

# Expondo a porta que a aplicação Spring Boot irá usar
EXPOSE 8080

# Comando para executar a aplicação
CMD ["java", "-jar", "vendas.jar"]
































