package lk.ijse.gdse.aad.possystemusingspring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "lk.ijse.gdse.aad.possystemusingspring")
@EnableJpaRepositories(basePackages = "lk.ijse.gdse.aad.possystemusingspring")
@EnableTransactionManagement
public class WebAppRootConfig {
}
