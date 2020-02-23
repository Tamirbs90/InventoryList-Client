FROM openjdk:12-alpine
EXPOSE 8080
ADD target/items-list.jar items-list.jar
CMD ["java", "-jar", "items-list.jar"]
