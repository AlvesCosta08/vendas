# Use a imagem base do OpenJDK para a fase de construção
FROM openjdk:21-jdk-slim AS build

# Defina o diretório de trabalho
WORKDIR /app

# Copie o arquivo pom.xml e o código fonte para o contêiner
COPY vendas/pom.xml ./
COPY vendas/src ./src

# Execute o Maven para construir a aplicação (caso use Maven)
RUN mvn clean package

# Fase de execução
FROM openjdk:21-jdk-slim

# Defina o diretório de trabalho
WORKDIR /app

# Copie o arquivo JAR da fase de construção para o contêiner
COPY --from=build /app/target/vendas-0.0.1-SNAPSHOT.jar app.jar

# Exponha a porta que a aplicação irá usar
EXPOSE 8080

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]


































