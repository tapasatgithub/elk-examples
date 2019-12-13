FROM openjdk:8-jre-alpine
COPY ./target/elk-example-1.0-SNAPSHOT-shaded.jar /tmp/elk/elk-example.jar
WORKDIR /tmp/elk
#RUN -v logdata:c:\logdata
VOLUME ["/logdata"]
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar elk-example.jar" ]
