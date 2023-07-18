# Building part
FROM eclipse-temurin:17 as builder

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN apt-get update && apt-get install dos2unix && apt-get clean
RUN dos2unix ./mvnw
RUN ./mvnw install -DskipTests
RUN java -Djarmode=layertools -jar target/*.jar extract

# Execution part
FROM eclipse-temurin:17
COPY --from=builder dependencies/ ./
COPY --from=builder snapshot-dependencies/ ./
COPY --from=builder spring-boot-loader/ ./
COPY --from=builder application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"] 