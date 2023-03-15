# How to build?
# docker build -t leniolabs:0.1.1 . --build-arg JAR_PATH_FILE=./target/payment-links-0.1.1-SNAPSHOT.jar
FROM openjdk:8-jdk-alpine

WORKDIR /app

EXPOSE 8081

COPY target/*.jar myapp.jar

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS\
                              -jar myapp.jar" ]
