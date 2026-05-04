# Use Java 21
FROM eclipse-temurin:21-jdk

# Copy project files
WORKDIR /app
COPY . .

# Build the project
RUN ./mvnw clean package -DskipTests

# Run the app
CMD ["java", "-jar", "target/*.jar"]
