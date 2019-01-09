FROM openjdk:8-jre-alpine

LABEL maintainer="<ianoniango94@gmail.com>"

ADD target/loans-service-0.0.1-SNAPSHOT.jar loans-service-0.0.1-SNAPSHOT.jar

EXPOSE 9070

ENV TZ=Africa/Nairobi

RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

ENTRYPOINT ["java","-Dspring.profiles.active=docker","-jar","loans-service-0.0.1-SNAPSHOT.jar"]
