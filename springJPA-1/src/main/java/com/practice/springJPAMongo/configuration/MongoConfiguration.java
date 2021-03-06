package com.practice.springJPAMongo.configuration;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories("com.practice.springJPAMongo.repository")
public class MongoConfiguration extends AbstractMongoClientConfiguration {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${spring.data.mongodb.database}")
    private String database;
    @Value("${spring.data.mongodb.host}")
    private String host;
    @Value("${spring.data.mongodb.port}")
    private String port;
    @Value("${spring.data.mongodb.username}")
    private String username;
    @Value("${spring.data.mongodb.password}")
    private String password;
    @Value("${spring.data.mongodb.uri}")
    private String uri;

    @Override
    protected String getDatabaseName() {
        return database;
    }

    public @Bean MongoClient mongoClient() {
        logger.info("Creating MongoClient");
        return MongoClients.create(uri);
    }
    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongoClient(), database);
    }
    @Bean
    MongoTransactionManager transactionManager(MongoDatabaseFactory mongoDatabaseFactory)
    {
        return new MongoTransactionManager(mongoDatabaseFactory);
    }

}
