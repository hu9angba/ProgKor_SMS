FROM openjdk:17-jdk-alpine3.14
COPY "./target/sms.jar" "/app/sms.jar"
EXPOSE 8080
CMD [ "java", "-jar", "/app/sms.jar" ]