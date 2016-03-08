package nl.ocwduo.vzub.service;

import nl.ocwduo.vzub.domain.dao.file.FileDao;
import nl.ocwduo.vzub.domain.model.file.File;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Machiel de Jager on 26-2-2016.
 */
public class CustomerFileService {
    private FileDao fileDao;

    @Autowired
    public CustomerFileService(FileDao fileDao) {
        this.fileDao = fileDao;
    }

    public File findFileById(Long id) {
        return fileDao.findOne(id);
    }

    public List<File> findFilesForUser(String userId) {
        return fileDao.findAll();
    }
}
