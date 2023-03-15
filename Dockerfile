# How to build?
# docker build -t payment-links:0.1.1 . --build-arg JAR_PATH_FILE=./target/payment-links-0.1.1-SNAPSHOT.jar
# How to run?
# docker run -d -p 27017:27017 --name mongo mongo:6.0.4
# docker run -e CLOUD_CONFIG_URI=http://host.docker.internal:8888 -e PROFILE=default -e MONGO_HOST=172.17.0.2 -p 8080:8080 payment-links:0.1.1
FROM openjdk:17-jdk-alpine

WORKDIR /app

EXPOSE 8080

COPY target/*.jar myapp.jar

# ************** ENVIRONMENT VARIABLES **************
# CLOUD_CONFIG_URI Use http://host.docker.internal:8888 to request local cloud config server machine
# JAVA_OPTS Java configurations
# PROFILE Use default or empty
# MONGO_HOST MongoDB's Host IP

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS\
                              -Dspring.profiles.active=$PROFILE\
                              -Dspring.cloud.config.uri=$CLOUD_CONFIG_URI\
                              -Dspring.data.mongodb.host=$MONGO_HOST\
                              -jar myapp.jar" ]
