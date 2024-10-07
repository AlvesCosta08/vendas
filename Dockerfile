# Etapa de build
FROM ubuntu:latest AS build

# Atualizando a lista de pacotes e instalando Java e Maven
RUN apt-get update && \
    apt-get install -y openjdk-21-jdk maven && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Define o diretório de trabalho
WORKDIR /app

# Copiando o código-fonte para a imagem
COPY . .

# Construindo o projeto
RUN mvn clean install -DskipTests

# Usando a imagem base do OpenJDK 21 slim para o runtime
FROM openjdk:21-slim

# Define o diretório de trabalho
WORKDIR /app

# Expondo a porta 8080
EXPOSE 8080

# Copiando o JAR gerado na etapa de build para a imagem final
COPY --from=build /app/target/vendas-*.jar app.jar

# Copiando o arquivo .env para a imagem final
COPY --from=build /app/.env ./

# Definindo o comando de entrada para executar o JAR
ENTRYPOINT ["java", "-jar", "app.jar"]

























