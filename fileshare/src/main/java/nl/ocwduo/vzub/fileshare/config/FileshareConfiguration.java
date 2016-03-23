package nl.ocwduo.vzub.fileshare.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Machiel de Jager on 29-2-2016.
 */
@Configuration
@ComponentScan("nl.ocwduo.vzub.fileshare")
public class FileshareConfiguration {
//    @Autowired
//    private Environment env;
//
//
//    @Bean
//    public DefaultSftpSessionFactory getDefaultSftpSessionFactory() {
//        DefaultSftpSessionFactory factory = new DefaultSftpSessionFactory();
//        factory.setHost("172.30.248.31:22");
//        factory.setPrivateKey(getSftpPrivateKey());
//        factory.setPrivateKeyPassphrase("caramelchew");
//        factory.setPort(22);
//        factory.setUser("zpuserwas");
//
//        return factory;
//    }
//
//    private Resource getSftpPrivateKey() {
//        AnnotationConfigApplicationContext ctx =
//                new AnnotationConfigApplicationContext();
//        Resource resource = ctx.getResource("D:\\JAVA\\Projects\\VZUB_JI\\workspaces\\herbouw\\file_exchange\\scripts\\nl.ocwduo.vzub.fileshare\\id_dsa_zpuserwas_fat.ppk");
//        return resource;
//    }

//    <beans:bean id="sftpSessionFactory"
//    class="org.springframework.integration.sftp.session.DefaultSftpSessionFactory">
//    <beans:property name="host" value="localhost"/>
//    <beans:property name="privateKey" value="classpath:META-INF/keys/sftpTest"/>
//    <beans:property name="privateKeyPassphrase" value="springIntegration"/>
//    <beans:property name="port" value="22"/>
//    <beans:property name="user" value="kermit"/>
//    </beans:bean>
}
