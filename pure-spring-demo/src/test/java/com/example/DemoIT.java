package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class DemoIT {

  @Test
  void defaultServletFromWebAppRoot() throws IOException {
    RestTemplate restTemplate = new RestTemplate();

    RequestEntity<Void> request =
        RequestEntity.get("http://localhost:8080/pure-spring-demo/static/css/app.css")
            .build();
    ResponseEntity<String> response = restTemplate.exchange(request, String.class);
    Assertions.assertEquals(Files.readString(Path.of("src/main/webapp/static/css/app.css"), StandardCharsets.UTF_8),
        response.getBody());
  }

  @Test
  void defaultServletFromExternalJarFile() throws IOException {
    RestTemplate restTemplate = new RestTemplate();

    RequestEntity<Void> request =
        RequestEntity.get("http://localhost:8080/pure-spring-demo/static/css/foo.css")
            .build();
    ResponseEntity<String> response = restTemplate.exchange(request, String.class);
    Assertions.assertEquals(Files.readString(Path.of("../shared-static-resources/src/main/resources/META-INF/resources/static/css/foo.css"), StandardCharsets.UTF_8),
        response.getBody());
  }

  @Test
  void mvcFromClasspathFile() throws IOException {
    RestTemplate restTemplate = new RestTemplate();

    RequestEntity<Void> request =
        RequestEntity.get("http://localhost:8080/pure-spring-demo/resources/css/bar.css")
            .build();
    ResponseEntity<String> response = restTemplate.exchange(request, String.class);
    Assertions.assertEquals(Files.readString(Path.of("src/main/resources/static/css/bar.css"), StandardCharsets.UTF_8),
        response.getBody());
  }

}
