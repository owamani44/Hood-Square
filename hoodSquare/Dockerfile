FROM eclipse-temurin:25-jammy AS builder

RUN apt-get update && apt-get install -y maven

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline -B

COPY src ./src

RUN mvn clean package

FROM amazoncorretto:25-jdk AS runner

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]