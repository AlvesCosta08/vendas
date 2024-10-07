# Use a imagem base do OpenJDK
FROM openjdk:21-jdk-slim

# Defina o diretório de trabalho
WORKDIR /app

# Copie o arquivo JAR da aplicação para o contêiner
COPY vendas/target/vendas-0.0.1-SNAPSHOT.jar app.jar

# Exponha a porta que a aplicação irá usar
EXPOSE 8080

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]

































