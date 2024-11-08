# Start with a Maven image to build the application
FROM maven:3.8.1-jdk-11 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy all project files to the working directory
COPY . .

# Build the project using Maven, creating a JAR file in the target directory
RUN mvn clean package

# Start with a lightweight JRE image for running the application
FROM openjdk:11-jre

# Set the working directory in the runtime environment
WORKDIR /app

# Copy the built JAR file from the build stage to the runtime stage
COPY --from=build /app/target/*.jar app.jar

# Run the application using the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
