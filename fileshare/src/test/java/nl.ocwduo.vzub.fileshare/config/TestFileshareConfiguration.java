package nl.ocwduo.vzub.fileshare.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.integration.config.EnableIntegration;

/**
 * Created by Machiel de Jager on 29-2-2016.
 */
@Configuration
@ComponentScan("nl.ocwduo.vzub.fileshare")
@Profile("unit-test")
@EnableIntegration
public class TestFileshareConfiguration {

}
