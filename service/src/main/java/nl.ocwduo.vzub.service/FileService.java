package nl.ocwduo.vzub.service;

import nl.ocwduo.vzub.dao.FileDao;
import nl.ocwduo.vzub.domain.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Max Hunt on 21-2-2016.
 */
@Service
public class FileService {

    private FileDao fileDao;

    @Autowired
    public FileService(FileDao fileDao) {
        this.fileDao = fileDao;
    }

    public File findFileById(long id) {
        return fileDao.findOne(id);
    }

    public List<File> findFilesForUser(String userId) {
        return fileDao.findAll();
    }
}
