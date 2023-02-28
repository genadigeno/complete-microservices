FROM openjdk:17-alpine

RUN mkdir "app"
WORKDIR /app

RUN mkdir "logs"
VOLUME $PWD/logs

COPY ./target/ui.jar .

ENV SERVER_PORT=8181
ENV APP_NUMBER=2
ENV CONFIG_SERVER_URL="http://localhost:8888"
ENV EUREKA_URL="http://localhost:8761/eureka/"
ENV RABBIT_QUEUE_NAME="spring-boot"
ENV RABBIT_EXCHANGE_NAME="spring-boot-exchange"
ENV RABBIT_ROUTING_KEY="foo.bar.#"
ENV RABBIT_PORT=5672
ENV RABBIT_HOST="localhost"
ENV RABBIT_USER="guest"
ENV RABBIT_PASS="guest"

EXPOSE ${SERVER_PORT}

ENTRYPOINT ["java", "-jar"]

CMD ["ui.jar"]