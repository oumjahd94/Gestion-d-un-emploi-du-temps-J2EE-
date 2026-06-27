FROM tomcat:7.0-jre8

# Remove default webapps
RUN rm -rf /usr/local/tomcat/webapps/ROOT

# Copy the WAR file with name ROOT to serve at root context
COPY monApplication.war /usr/local/tomcat/webapps/ROOT.war

# Copy MySQL JDBC driver to Tomcat lib
COPY WebContent/WEB-INF/lib/mysql-connector-java-5.1.5-bin.jar /usr/local/tomcat/lib/

# Expose port 8080
EXPOSE 8080

# Set UTF-8 encoding
ENV JAVA_OPTS="-Dfile.encoding=UTF-8"

CMD ["catalina.sh", "run"]

