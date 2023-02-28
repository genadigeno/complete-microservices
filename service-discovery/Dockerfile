FROM openjdk:17-alpine

RUN mkdir "app"
WORKDIR /app

RUN mkdir "logs"
VOLUME $pwd/logs

COPY ./target/service-discovery.jar .

ENV SERVER_PORT=8761

EXPOSE ${SERVER_PORT}

ENTRYPOINT ["java", "-jar"]

CMD ["service-discovery.jar"]