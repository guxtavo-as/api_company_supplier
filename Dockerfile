
# Etapa de build
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app

# Copia os arquivos de configuração e dependências primeiro (cache das dependências)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copia o código
COPY src ./src

# Builda a aplicação
RUN mvn clean package -DskipTests

# Etapa de runtime
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copia o JAR gerado
COPY --from=build /app/target/*.jar app.jar

# Profile é definido no docker-compose
ENTRYPOINT ["java","-jar","/app/app.jar"]
