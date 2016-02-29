package nl.ocwduo.vzub.domain.dao;

import nl.ocwduo.vzub.dao.BackofficeFileDao;
import nl.ocwduo.vzub.domain.BackofficeFile;
import nl.ocwduo.vzub.domain.EmailNotification;
import nl.ocwduo.vzub.domain.config.TestDomainConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by in434jag on 29-2-2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDomainConfiguration.class)
@ActiveProfiles("unit-test")
public class BackofficeFileDaoTest {

    @Autowired
    private BackofficeFileDao backofficeFileDao;

    @Test
    public void testSavingBackofficeFileToDatabase() {
        BackofficeFile file = new BackofficeFile();
        file = backofficeFileDao.save(file);
        file.setEmailNotification(new EmailNotification());
        file = backofficeFileDao.save(file);
        System.out.println("File id is: " + file.getId());
        backofficeFileDao.findOne(file.getId());
    }

}
