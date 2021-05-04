package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringBootDemoApplicationTests {

  @Autowired
  TestRestTemplate restTemplate;

  @Test
  void fromPublic() throws IOException {
    ResponseEntity<String> response = restTemplate.exchange("/css/a.css", HttpMethod.GET, null, String.class);
    Assertions.assertEquals(Files.readString(Path.of("src/main/resources/public/css/a.css"), StandardCharsets.UTF_8),
        response.getBody());
  }

  @Test
  void fromStatic() throws IOException {
    ResponseEntity<String> response = restTemplate.exchange("/css/c.css", HttpMethod.GET, null, String.class);
    Assertions.assertEquals(Files.readString(Path.of("src/main/resources/static/css/c.css"), StandardCharsets.UTF_8),
        response.getBody());
  }

  @Test
  void fromResources() throws IOException {
    ResponseEntity<String> response = restTemplate.exchange("/css/b.css", HttpMethod.GET, null, String.class);
    Assertions.assertEquals(Files.readString(Path.of("src/main/resources/resources/css/b.css"), StandardCharsets.UTF_8),
        response.getBody());
  }

  @Test
  void fromExternalJar() throws IOException {
    ResponseEntity<String> response = restTemplate.exchange("/static/css/foo.css", HttpMethod.GET, null, String.class);
    Assertions.assertEquals(StreamUtils.copyToString(new ClassPathResource("META-INF/resources/static/css/foo.css").getInputStream(), StandardCharsets.UTF_8),
        response.getBody());
  }

}
