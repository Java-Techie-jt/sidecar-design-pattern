# Use the official OpenJDK 17 image from Docker Hub
FROM openjdk:21
# Set working directory inside the container
VOLUME /tmp
VOLUME /logs

WORKDIR /app
# Copy the compiled Java application JAR file into the container
COPY ./target/book-service.jar /app
# Expose the port the Spring Boot application will run on
EXPOSE 8080
# Command to run the application
CMD ["java", "-jar", "book-service.jar"]