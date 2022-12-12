#!/usr/bin/env bash
curl -LO https://github.com/honeycombio/honeycomb-opentelemetry-java/releases/download/v1.4.0/honeycomb-opentelemetry-javaagent-1.4.0.jar &&\
mvn clean package && \
java -javaagent:./honeycomb-opentelemetry-javaagent-1.4.0.jar -jar ./target/opentelementry-spring-boot-0.0.1-SNAPSHOT.jar