# Use a imagem base do Ubuntu
FROM ubuntu:latest

# Instale o Java 21 e Maven
RUN apt-get update && apt-get install -y openjdk-21-jdk maven && apt-get clean && rm -rf /var/lib/apt/lists/*

# Define o diretório de trabalho na imagem
WORKDIR /app

# Copia o arquivo JAR da aplicação para o diretório de trabalho
COPY target/vendas-*.jar app.jar

# Copia o arquivo .env para o diretório de trabalho
COPY .env ./

# Exponha a porta que a aplicação irá rodar
EXPOSE 8080

# Comando para rodar a aplicação
CMD ["java", "-jar", "app.jar"]



