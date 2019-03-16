# spring-boot junit5 minimal setup
Spring Boot 2.x and Junit 5 minimum required pom.xml configuration

_pom.xml_

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project ...>
  <parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.1.3.RELEASE</version>
    <relativePath/>
  </parent>

  <properties>
    <junit-jupiter.version>5.4.0</junit-jupiter.version>
  </properties>

  <dependencies>
    <dependency>
      <groupId>org.junit.jupiter</groupId>
      <artifactId>junit-jupiter-api</artifactId>
      <scope>test</scope>
    </dependency>
    <dependency>
      <groupId>org.junit.jupiter</groupId>
      <artifactId>junit-jupiter-engine</artifactId>
      <scope>test</scope>
    </dependency>
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-test</artifactId>
      <scope>test</scope>
    </dependency>
  </dependencies>
</project>
```

_src/test/java/../ApplicationUnderTest.java_

```java
@TestConfiguration
@SpringBootApplication
class ApplicationUnderTest {

  @Bean
  String aString() {
    return "Hello!";
  }

  public static void main(String[] args) {
    SpringApplication.run(ApplicationUnderTest.class, args);
  }
}

@SpringBootTest
@ExtendWith(SpringExtension.class)
class MyTest {

  @Autowired
  String aString;

  @Test
  void test() {
    assertThat(aString).isEqualTo("Hello!");
  }
}
```
