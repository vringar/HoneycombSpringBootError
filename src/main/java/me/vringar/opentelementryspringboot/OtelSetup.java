package me.vringar.opentelementryspringboot;

import io.honeycomb.opentelemetry.OpenTelemetryConfiguration;
import io.opentelemetry.api.OpenTelemetry;
import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OtelSetup {

  @Value("${honeycomb.api.key}")
  private String API_KEY;

  @Value("${spring.application.name}")
  private String NAME;

 @PostConstruct
  public OpenTelemetry honeycomb() {
    return OpenTelemetryConfiguration.builder()
        .setApiKey(API_KEY)
        .setServiceName(NAME)
        //.addSpanProcessor(SimpleSpanProcessor.create(LoggingSpanExporter.create())) // fordebugging
        .buildAndRegisterGlobal();
  }
}