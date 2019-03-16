package com.github.daggerok;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@TestConfiguration
@SpringBootApplication
class MyTestSpringBootApp {

  @Bean
  String myString() {
    return "Hello!";
  }

  public static void main(String[] args) {
    new SpringApplicationBuilder(MyTestSpringBootApp.class)
        .properties("spring.output.ansi.enabled=always")
        .build()
        .run(args);
  }
}

@SpringBootTest
@ExtendWith(SpringExtension.class)
class SpringBootMinimalTests {

  @Autowired
  SpringBootMinimalTests(String myString) {
    this.myString = myString;
  }

  final String myString;

  @Test
  void test() {
    assertThat(myString).isEqualTo("Hello!");
  }
}
