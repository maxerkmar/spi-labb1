FROM eclipse-temurin:22-jre-alpine AS builder
RUN mkdir app
COPY consumer/target/consumer-1.0-SNAPSHOT.jar  /app/
COPY service/target/service-1.0-SNAPSHOT.jar /app/
COPY provider/target/provider-1.0-SNAPSHOT.jar /app/

FROM eclipse-temurin:22-jre-alpine
WORKDIR /app
COPY --from=builder /app .
CMD java --module-path . -m org.example.consumer/org.example.consumer.Main


