FROM openjdk:11
EXPOSE 8089
RUN ls -l /target  # Display contents of /target directory
COPY target/achat-1.0.jar achat-1.0.jar
ENTRYPOINT ["java","-jar","/achat-1.0.jar"]