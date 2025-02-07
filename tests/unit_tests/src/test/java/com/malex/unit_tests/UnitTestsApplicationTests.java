package com.malex.unit_tests;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.mongo.StandardMongoClientSettingsBuilderCustomizer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
class UnitTestsApplicationTests {

  @MockitoBean private StandardMongoClientSettingsBuilderCustomizer customizer;

  @Test
  void contextLoads() {}
}
