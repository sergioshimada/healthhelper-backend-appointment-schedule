# Use uma imagem base do OpenJDK 21
FROM openjdk:21-jdk-slim

# Defina o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copie o arquivo JAR do projeto para o contêiner
COPY target/*.jar /app/app.jar

# Exponha a porta 8080
EXPOSE 8080

# Comando para rodar o aplicativo
ENTRYPOINT ["java", "-jar", "/app/app.jar"]