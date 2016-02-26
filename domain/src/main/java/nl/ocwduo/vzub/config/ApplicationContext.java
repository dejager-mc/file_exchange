package nl.ocwduo.vzub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by Machiel de Jager on 20-2-2016.
 */
@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
public class ApplicationContext {

    @Bean
    public DataSource dataSourceVzub() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName();
//        dataSource.setUrl();
//        dataSource.setUsername();
//        dataSource.setPassword();
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSourceVzub());
        return transactionManager;
    }
}
