FROM openjdk:11

EXPOSE 9090

ADD build/libs/AppServerSample-0.0.1-SNAPSHOT.jar AppServerSample-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar","AppServerSample-0.0.1-SNAPSHOT.jar"]
