FROM eclipse-temurin:21-jdk

WORKDIR /app
COPY . .

# 🔥 FIX: give permission to mvnw
RUN chmod +x mvnw

# build project
RUN ./mvnw clean package -DskipTests

# run app
CMD ["java", "-jar", "target/*.jar"]
