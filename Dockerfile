FROM openjdk:20
COPY target/ex-rest-0.0.1-SNAPSHOT.jar ex-rest-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005", "-jar", "/ex-rest-0.0.1-SNAPSHOT.jar"]
