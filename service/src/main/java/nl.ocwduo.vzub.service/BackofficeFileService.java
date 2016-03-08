package nl.ocwduo.vzub.service;

import nl.ocwduo.vzub.domain.dao.file.FileDao;
import nl.ocwduo.vzub.domain.model.file.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Machiel de Jager on 21-2-2016.
 */
@Service
public class BackofficeFileService {

    private FileDao fileDao;

    @Autowired
    public BackofficeFileService(FileDao fileDao) {
        this.fileDao = fileDao;
    }

    public File findFileById(Long id) {
        return fileDao.findOne(id);
    }

    public List<File> findFilesForUser(String userId) {
        return fileDao.findAll();
    }
}
