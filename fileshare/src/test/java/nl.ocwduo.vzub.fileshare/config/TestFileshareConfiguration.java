package nl.ocwduo.vzub.fileshare.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.sftp.session.DefaultSftpSessionFactory;

import java.util.Properties;

/**
 * Created by Machiel de Jager on 29-2-2016.
 */
@Configuration
@ComponentScan("nl.ocwduo.vzub.fileshare")
@Profile("unit-test")
@EnableIntegration
public class TestFileshareConfiguration {
    @Autowired
    private Environment env;

    @Value("D:\\JAVA\\Projects\\VZUB_JI\\workspaces\\herbouw\\file_exchange\\scripts\\nl.ocwduo.vzub.fileshare\\id_dsa_zpuserwas_fat.ppk")
    private Resource myKey;

    @Bean
    public DefaultSftpSessionFactory getDefaultSftpSessionFactory() {
        DefaultSftpSessionFactory factory = new DefaultSftpSessionFactory();
        factory.setHost("172.30.248.31:22");
        factory.setPrivateKey(myKey);
        factory.setPrivateKeyPassphrase("caramelchew");
        factory.setPort(22);
        factory.setUser("zpuserwas");
        Properties sessionConfig = new Properties();
        factory.setSessionConfig(sessionConfig);

        return factory;
    }

    private Resource getSftpPrivateKey() {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext();
        Resource resource = ctx.getResource("D:\\JAVA\\Projects\\VZUB_JI\\workspaces\\herbouw\\file_exchange\\scripts\\nl.ocwduo.vzub.fileshare\\id_dsa_zpuserwas_fat.ppk");
        return resource;
    }

}
