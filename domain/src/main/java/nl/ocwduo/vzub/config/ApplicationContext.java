package nl.ocwduo.vzub.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Machiel de Jager on 20-2-2016.
 */
@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
public class ApplicationContext {
}
