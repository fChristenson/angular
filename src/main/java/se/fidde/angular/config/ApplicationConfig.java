package se.fidde.angular.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import se.fidde.angular.repository.PersonRepository;
import se.fidde.angular.service.PersonService;
import se.fidde.angular.service.PersonServiceImpl;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories(basePackageClasses = { PersonRepository.class })
public class ApplicationConfig extends AbstractMongoConfiguration {

    @Bean
    public PersonService personService() {
        return new PersonServiceImpl();
    }

    @Override
    protected String getDatabaseName() {
        return "test";
    }

    @Override
    @Bean
    public Mongo mongo() throws Exception {
        return new MongoClient("localhost");
    }

    @Override
    protected String getMappingBasePackage() {
        return "se.fidde.angular.repository";
    }

}
