package nl.ocwduo.vzub.domain.dao;

import nl.ocwduo.vzub.domain.dao.file.FileDao;
import nl.ocwduo.vzub.domain.main.testMain;
import nl.ocwduo.vzub.domain.model.file.File;
import nl.ocwduo.vzub.domain.model.file.details.FileSpecs;
import nl.ocwduo.vzub.domain.model.file.details.FileStatus;
import nl.ocwduo.vzub.domain.model.file.enums.BackofficeFileStatus;
import nl.ocwduo.vzub.domain.model.fileType.FileType;
import nl.ocwduo.vzub.domain.model.fileType.details.EmailNotification;
import nl.ocwduo.vzub.domain.model.fileType.details.FileTimeManagement;
import nl.ocwduo.vzub.domain.model.fileType.enums.FileKind;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * Created by in434jag on 29-2-2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class BackofficeFileDaoTestIntegration extends testMain {

    @Autowired
    private FileDao fileDao;
    @Autowired
    private nl.ocwduo.vzub.domain.dao.fileType.fileTypeDao fileTypeDao;

    @After
    public void clearDataFromDatabase() {
        fileDao.findAll()
                .stream()
                .forEach(file -> deleteFile(file));

        fileTypeDao.findAll()
                .stream()
                .forEach(fileType -> deleteFileType(fileType));
    }

    public void deleteFileType(FileType fileType) {
        fileTypeDao.delete(fileType);
    }

    public void deleteFile(File file) {
        fileDao.delete(file);
    }

    @Test
    @Transactional
    public void testSaveFileWithExistingFileType() {
        // maak filetype
        FileType fileType = getBackOfficeDefaultFileType();
        fileType = fileTypeDao.save(fileType);

        // maak file
        File file = getBackOfficeDefaultFile();
        file.setFileType(fileType);
        file = fileDao.save(file);
    }

    @Test
    @Transactional
    public void testSaveFileWithExistingFileTypeCheckIfCleanupWorks() {
        // maak filetype
        FileType fileType = getBackOfficeDefaultFileType();
        fileType = fileTypeDao.save(fileType);

        // maak file
        File file = getBackOfficeDefaultFile();
        file.setFileType(fileType);
        file = fileDao.save(file);
    }

   private File getBackOfficeDefaultFile() {
       File file = new File();
       file.setFileSpecs(getFileSpecs());
       file.getHistory().add(getBackOfficeDefaultFileStatus());
       return file;
   }

    private FileStatus getBackOfficeDefaultFileStatus() {
        FileStatus fileStatus = new FileStatus();
        fileStatus.setMoment(LocalDateTime.now().toEpochSecond(ZoneOffset.ofTotalSeconds(0)));
        fileStatus.setStatus(BackofficeFileStatus.BESTAND_AANGEMAAKT.toString());
        return fileStatus;
    }

    private FileSpecs getFileSpecs() {
        FileSpecs fileSpecs = new FileSpecs();
        fileSpecs.setFileName("file_name");
        fileSpecs.setFilePath("/");
        fileSpecs.setFileSize(5L);
        return fileSpecs;
    }

    private EmailNotification getEmailNotification() {
        EmailNotification emailNotification = new EmailNotification();
        emailNotification.setContent("content");
        emailNotification.setFromEmailAddress("from@emailadres");
        emailNotification.setSubject("subject");
        return emailNotification;
    }

    private FileTimeManagement getFileTimeManagement() {
        FileTimeManagement fileTimeManagement = new FileTimeManagement();
        fileTimeManagement.setKeepFileAfterDownloadingForDays(1);
        fileTimeManagement.setKeepFileForDays(1);
        fileTimeManagement.setWaitForSomethingForDays(1);
        return fileTimeManagement;
    }

    private FileType getBackOfficeDefaultFileType() {
        FileType fileType = new FileType();
        fileType.setFileKind(FileKind.BACKOFFICE_FILE);

        fileType.setDiscription("BackOfficeFileType");
        fileType.setName("BackOfficeFileType");

        fileType.setEmailNotification(getEmailNotification());
        fileType.setFileTimeManagement(getFileTimeManagement());

        return fileType;
    }
}
