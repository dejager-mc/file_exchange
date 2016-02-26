package nl.ocwduo.vzub.service;

import nl.ocwduo.vzub.dao.CustomerFileDao;
import nl.ocwduo.vzub.domain.CustomerFile;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Machiel de Jager on 26-2-2016.
 */
public class CustomerFileService {
    private CustomerFileDao customerFileDao;

    @Autowired
    public CustomerFileService(CustomerFileDao customerFileDao) {
        this.customerFileDao = customerFileDao;
    }

    public CustomerFile findFileById(Long id) {
        return customerFileDao.findOne(id);
    }

    public List<CustomerFile> findFilesForUser(String userId) {
        return customerFileDao.findAll();
    }
}
