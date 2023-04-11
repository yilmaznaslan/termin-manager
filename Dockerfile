# Build stage
FROM openjdk:17-alpine as builder

RUN apk add --no-cache git

RUN git clone https://github.com/yilmaznaslan/termin-manager.git

WORKDIR /termin-manager

RUN git fetch && git checkout master && ./gradlew build

# Runtime stage
FROM openjdk:17-alpine

EXPOSE 8080

COPY --from=builder /termin-manager/build/libs/*.jar /app.jar

CMD ["java", "-jar", "/app.jar"]
