# Use the Tomcat image as base
FROM tomcat:9.0-jdk11-openjdk-slim

# Remove old WAR files and directories if they exist
RUN rm -rf /usr/local/tomcat/webapps/ROOT \
    && rm -rf /usr/local/tomcat/webapps/mywebapp.war

# Copy the WAR (Web ARchive) file of your Maven application into Tomcat's webapps directory and rename it
COPY target/FormToMYSQL-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/mywebapp.war

# Expose port 8080 on which Tomcat is running
EXPOSE 8080
