FROM openjdk:17-alpine

RUN mkdir "app"
WORKDIR /app

RUN mkdir "logs"
VOLUME $PWD/logs

COPY ./target/data-stream.jar .

ENV EUREKA_URL="http://localhost:8761/eureka/"
ENV API_GATEWAY_URL="http://localhost:8080/stream"
ENV CONFIG_SERVER_URL="http://localhost:8888"
ENV RABBIT_QUEUE_NAME="spring-boot"
ENV RABBIT_EXCHANGE_NAME="spring-boot-exchange"
ENV RABBIT_ROUTING_KEY="foo.bar.#"
ENV RABBIT_PORT=5672
ENV RABBIT_HOST="localhost"
ENV RABBIT_USER="guest"
ENV RABBIT_PASS="guest"
ENV SERVER_PORT=8280

EXPOSE ${SERVER_PORT}

ENTRYPOINT ["java", "-jar"]
#ENTRYPOINT ["java", "-Dserver.port=${SERVER_PORT}" , "-jar"]

CMD ["data-stream.jar"]