FROM openjdk:11

EXPOSE 9090

ADD build/libs/AppServer-0.0.1-SNAPSHOT.jar AppServer-0.0.1-SNAPSHOT.jar

#ENTRYPOINT ["nohup", "java", "-jar","AppServer-0.0.1-SNAPSHOT.jar","&"]

ENTRYPOINT ["java", "-jar","AppServer-0.0.1-SNAPSHOT.jar"]