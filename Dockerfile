FROM openjdk:17
EXPOSE 5001
ADD target/Crud-Department.jar Crud-Department.jar
ENTRYPOINT [ "java","-jar","/Crud-Department.jar"]