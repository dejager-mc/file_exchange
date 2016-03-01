package nl.ocwduo.vzub.domain.main;

import nl.ocwduo.vzub.domain.config.TestDomainConfigurationIntegration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by Max Hunt on 1-3-2016.
 */

@ContextConfiguration(classes = TestDomainConfigurationIntegration.class)
@ActiveProfiles("unit-test")
public class testMain {

}
