FROM openjdk:17-oracle
EXPOSE 8084
ADD /target/mc-mongo-provider-0.0.1-SNAPSHOT.jar mc-mongo-provider.jar
ENTRYPOINT ["java", "-jar", "mc-mongo-provider.jar"]
