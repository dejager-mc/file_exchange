package nl.ocwduo.vzub.fileshare.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.AbstractPlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Machiel de Jager on 29-2-2016.
 */
@Configuration
@ComponentScan("nl.ocwduo.vzub.fileshare")
public class FileshareConfiguration {
    @Autowired
    private Environment env;


    @Bean
    public DefaultSftpSessionFactory getDefaultSftpSessionFactory() {

    }

    <beans:bean id="sftpSessionFactory"
    class="org.springframework.integration.sftp.session.DefaultSftpSessionFactory">
    <beans:property name="host" value="localhost"/>
    <beans:property name="privateKey" value="classpath:META-INF/keys/sftpTest"/>
    <beans:property name="privateKeyPassphrase" value="springIntegration"/>
    <beans:property name="port" value="22"/>
    <beans:property name="user" value="kermit"/>
    </beans:bean>
}
