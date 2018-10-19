#Simple spring boot docker image
#Database connection is nog handled here and requires extra configuration
FROM openjdk:11.0-jdk

ADD web/target/wicket-application.jar etc/application.jar
ENTRYPOINT ["java","-Xms1G", "-Xmx1G","-Dspring.profiles.active=production","-jar","etc/application.jar"]
