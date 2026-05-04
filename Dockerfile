# Use Java 21
FROM eclipse-temurin:21-jdk

# Set working directory
WORKDIR /app

# Copy everything
COPY . .

# Give permission to mvnw
RUN chmod +x mvnw

# Build the project (skip tests for faster build)
RUN ./mvnw clean package -DskipTests

# Expose port (Render uses 8080 internally)
EXPOSE 8080

# Run the app (wildcard handled properly)
CMD ["sh", "-c", "java -jar target/*.jar"]
