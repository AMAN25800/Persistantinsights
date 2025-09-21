# Step 1: Use a JDK image to build and run
FROM openjdk:17-jdk-slim

# Step 2: Set working directory
WORKDIR /app

# Step 3: Copy the jar file into container
COPY target/*.jar app.jar

# Step 4: Expose port
EXPOSE 8081

# Step 5: Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]
