FROM openjdk:17-alpine

COPY build/libs/termin-manager-1.0-SNAPSHOT.jar /termin-manager-1.0-SNAPSHOT.jar

EXPOSE 8080

CMD ["java", "-jar", "termin-manager-1.0-SNAPSHOT.jar"]