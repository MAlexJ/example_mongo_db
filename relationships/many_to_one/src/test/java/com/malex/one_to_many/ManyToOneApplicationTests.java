package com.malex.one_to_many;

import com.malex.one_to_many.configuration.MongoConfiguration;
import com.malex.one_to_many.repository.RoleRepository;
import com.malex.one_to_many.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.mongo.StandardMongoClientSettingsBuilderCustomizer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoManagedTypes;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.transaction.support.TransactionTemplate;

@SpringBootTest
class ManyToOneApplicationTests {

  @MockitoBean private StandardMongoClientSettingsBuilderCustomizer customizer;
  @MockitoBean private MongoConfiguration configuration;
  @MockitoBean private MongoDatabaseFactory mongoDatabaseFactory;
  @MockitoBean private MappingMongoConverter mappingMongoConverter;
  @MockitoBean private MongoCustomConversions mongoCustomConversions;
  @MockitoBean private MongoManagedTypes mongoManagedTypes;
  @MockitoBean private MongoTemplate mongoTemplate;
  @MockitoBean private GridFsTemplate gridFsTemplate;
  @MockitoBean private TransactionTemplate transactionTemplate;
  @MockitoBean private RoleRepository roleRepository;
  @MockitoBean private UserRepository userRepository;

  @Test
  void contextLoads() {}
}
