FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copiar todo el contenido del proyecto
COPY . .

# ESTO ES PARA DEPURAR: Veremos en el log qué archivos hay realmente
RUN ls -R

# Ejecutar la compilación
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
