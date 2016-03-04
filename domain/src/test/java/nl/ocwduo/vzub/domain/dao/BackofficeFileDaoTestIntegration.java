package nl.ocwduo.vzub.domain.dao;

import nl.ocwduo.vzub.domain.main.testMain;
import nl.ocwduo.vzub.domain.model.file.BackofficeFile;
import nl.ocwduo.vzub.domain.model.fileConfig.details.EmailNotification;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by in434jag on 29-2-2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class BackofficeFileDaoTestIntegration extends testMain {

    @Autowired
    private BackofficeFileDao backofficeFileDao;

    @Test
    @Transactional
    public void testSavingBackofficeFileToDatabase() {
        BackofficeFile file = new BackofficeFile();
        file = backofficeFileDao.save(file);
        file.setEmailNotification(new EmailNotification());
        file = backofficeFileDao.save(file);
        long fileId = file.getId();
        file = null;

        file = backofficeFileDao.findOne(fileId);
        System.out.println("File id is: " + file.getId());
    }
}
