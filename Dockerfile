FROM openjdk:17-alpine

EXPOSE 8080

COPY build/libs/termin-manager-1.0-SNAPSHOT.jar /termin-manager-1.0-SNAPSHOT.jar

CMD ["java", "-jar", "termin-manager-1.0-SNAPSHOT.jar"]
