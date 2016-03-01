package nl.ocwduo.vzub.domain.dao;

import nl.ocwduo.vzub.domain.main.testMain;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Max Hunt on 1-3-2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class GftKanaalDaoTestIntegration extends testMain {

    @Autowired
    private GftKanaalDao gftKanaalDao;

    @Test
    @Transactional
    public void testOphalenBestaandKanaal() {
        int size = gftKanaalDao.findAll().size();
        System.out.println("Size bestaande kanalen: " + size);
    }
}
