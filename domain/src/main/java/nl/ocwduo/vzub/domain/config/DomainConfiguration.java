package nl.ocwduo.vzub.domain.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Machiel de Jager on 29-2-2016.
 */
@Configuration
@EnableJpaRepositories(basePackages = "nl.ocwduo.vzub.domain")
@EnableTransactionManagement
public class DomainConfiguration {

    // annotation driven
    // jee jndi lookup datasource
    // entitymanager
    // transactionmanager


}
