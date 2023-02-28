FROM openjdk:17-alpine

RUN mkdir "app"
WORKDIR /app

RUN mkdir "logs"
VOLUME $PWD/logs

COPY ./target/api-gateway.jar .

ENV SERVER_PORT=8080
ENV EUREKA_URL="http://localhost:8761"

EXPOSE ${SERVER_PORT}

ENTRYPOINT ["java", "-jar"]

CMD ["api-gateway.jar"]