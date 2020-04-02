#Start with a base image containing Java runtime
FROM openjdk:11-slim

# Add Maintainer Info
MAINTAINER "Eugene Pavlenko" "kivcus@gmail.com"

#Add volume pointing to /tmp
VOLUME /tmp

# The application's jar file
ARG JAR_FILE

# Add the application's jar to the container
COPY ${JAR_FILE} app.jar

#execute the application
ENTRYPOINT ["java","-jar","/app.jar"]
