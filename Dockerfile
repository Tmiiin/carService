FROM openjdk:8u252-jdk
EXPOSE 8888
EXPOSE 5432
COPY target/car-service-*.jar car-service.jar
ENTRYPOINT exec java $JAVA_OPTS -jar car-service.jar