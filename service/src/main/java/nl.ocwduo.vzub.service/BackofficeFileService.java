package nl.ocwduo.vzub.service;

import nl.ocwduo.vzub.dao.BackofficeFileDao;
import nl.ocwduo.vzub.domain.FileSpecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Machiel de Jager on 21-2-2016.
 */
@Service
public class BackofficeFileService {

    private BackofficeFileDao backofficeFileDao;

    @Autowired
    public BackofficeFileService(BackofficeFileDao backofficeFileDao) {
        this.backofficeFileDao = backofficeFileDao;
    }

    public FileSpecs findFileById(long id) {
        return backofficeFileDao.findOne(id);
    }

    public List<FileSpecs> findFilesForUser(String userId) {
        return backofficeFileDao.findAll();
    }
}
