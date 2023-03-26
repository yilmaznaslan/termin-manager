FROM openjdk:17-alpine

COPY build/libs/terminManager-1.0-SNAPSHOT-all.jar /terminManager-1.0-SNAPSHOT-all.jar

CMD ["java", "-jar", "terminManager-1.0-SNAPSHOT-all.jar"]