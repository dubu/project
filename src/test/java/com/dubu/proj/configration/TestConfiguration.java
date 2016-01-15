package com.dubu.proj.configration;

import com.dubu.proj.dao.CustomerDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.inject.Inject;

@Configuration
//@Import(AppConfiguration.class)
@Import(JdbcConfiguration.class)
@EnableTransactionManagement
public class TestConfiguration {

    @Inject
    Environment env;

    @Bean
    public CustomerDao customerDao() {
        return new CustomerDao();
    }


}
