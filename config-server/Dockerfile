FROM openjdk:17-alpine

RUN mkdir "app"
WORKDIR /app

RUN mkdir "logs"
VOLUME $pwd/logs

COPY ./target/config-server.jar .

ENV EUREKA_URL="http://localhost:8761"
ENV GIT_URL="https://github.com/genadigeno/microservice-config-server.git"
ENV RABBIT_QUEUE_NAME="spring-boot"
ENV RABBIT_EXCHANGE_NAME="spring-boot-exchange"
ENV RABBIT_ROUTING_KEY="foo.bar.#"
ENV RABBIT_PORT=5672
ENV RABBIT_HOST="localhost"
ENV RABBIT_USER="guest"
ENV RABBIT_PASS="guest"
ENV SERVER_PORT=8888

EXPOSE ${SERVER_PORT}

ENTRYPOINT ["java", "-jar"]

CMD ["config-server.jar"]