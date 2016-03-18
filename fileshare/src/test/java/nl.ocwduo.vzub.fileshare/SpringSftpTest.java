package nl.ocwduo.vzub.fileshare;

import nl.ocwduo.vzub.fileshare.config.TestFileshareConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.sftp.session.DefaultSftpSessionFactory;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Max Hunt on 1-3-2016.
 */

@ContextConfiguration(classes = TestFileshareConfiguration.class)
@ActiveProfiles("unit-test")
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext
public class SpringSftpTest {

    @Autowired
    private DefaultSftpSessionFactory defaultSftpSessionFactory;

    @Test
    public void testMakeConnectionToSftp() {
        defaultSftpSessionFactory.getSession();
    }

}
