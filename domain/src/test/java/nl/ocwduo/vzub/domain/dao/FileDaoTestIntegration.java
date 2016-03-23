package nl.ocwduo.vzub.domain.dao;

import nl.ocwduo.vzub.domain.dao.file.FileDao;
import nl.ocwduo.vzub.domain.dao.fileType.FileTypeDao;
import nl.ocwduo.vzub.domain.main.testMain;
import nl.ocwduo.vzub.domain.model.file.File;
import nl.ocwduo.vzub.domain.model.file.details.FileSpecs;
import nl.ocwduo.vzub.domain.model.file.details.FileStatus;
import nl.ocwduo.vzub.domain.model.file.enums.BackofficeFileStatus;
import nl.ocwduo.vzub.domain.model.fileType.FileType;
import nl.ocwduo.vzub.domain.model.fileType.details.EmailNotification;
import nl.ocwduo.vzub.domain.model.fileType.details.FileTimeManagement;
import nl.ocwduo.vzub.domain.model.fileType.enums.FileKind;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by in434jag on 29-2-2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class FileDaoTestIntegration extends testMain {

    @Autowired
    private FileDao fileDao;
    @Autowired
    private FileTypeDao fileTypeDao;

//    @After
    @Before
    public void clearDataFromDatabase() {
//        fileDao.findAll()
//                .stream()
//                .forEach(file -> deleteFile(file));

        for (File file : fileDao.findAll()) {
            deleteFile(file);
        }

//        fileTypeDao.findAll()
//                .stream()
//                .forEach(fileType -> deleteFileType(fileType));

        for (FileType fileType : fileTypeDao.findAll()) {
            deleteFileType(fileType);
        }
    }

    public void deleteFileType(FileType fileType) {
        fileTypeDao.delete(fileType);
    }

    public void deleteFile(File file) {
        fileDao.delete(file);
    }

    public Long getIdSavedFile() {
        // maak filetype
        FileType fileType = saveFileType(getBackOfficeDefaultFileType());

        // maak file
        File file = getBackOfficeDefaultFile();
        file.setFileType(fileType);
        file = fileDao.save(file);
        assertNotNull("File id moet bestaan", file.getId());

        return file.getId();
    }

    public Long getIdSavedFileType() {
        // maak filetype
        FileType fileType = getBackOfficeDefaultFileType();
        fileType = saveFileType(fileType);

        // maak file
        File file = getBackOfficeDefaultFile();
        file.setFileType(fileType);
        file = saveFile(file);

        assertNotNull("FileType id moet niet null zijn", fileType.getId());

        return fileType.getId();
    }

    private FileType saveFileType(FileType fileType) {
        return fileTypeDao.save(fileType);
    }

    private File saveFile(File file) {
        return fileDao.save(file);
    }

    @Test
    @Transactional
    public void testSaveFile() {
        // maak filetype
        FileType fileType = getBackOfficeDefaultFileType();
        fileType = fileTypeDao.save(fileType);

        // maak file
        File file = getBackOfficeDefaultFile();
        file.setFileType(fileType);
        file = fileDao.save(file);
        assertNotNull("File id moet niet null zijn", file.getId());
    }

    @Test
    @Transactional
    public void testSaveFileAgain() {
        // maak filetype
        FileType fileType = saveFileType(getBackOfficeDefaultFileType());

        // maak file
        File file = getBackOfficeDefaultFile();
        file.setFileType(fileType);
        file = fileDao.save(file);
        assertNotNull("File id moet niet null zijn", file.getId());
    }

    @Test
    @Transactional
    public void testSaveMultipleFilesWithTheSameFileType() {
        // maak filetype
        FileType fileType = getBackOfficeDefaultFileType();
        fileType = fileTypeDao.save(fileType);

        // maak file
        File file = getBackOfficeDefaultFile();
        file.setFileType(fileType);
        file = fileDao.save(file);
        assertNotNull("File 1 id moet niet null zijn", file.getId());

        // maak file nog een file
        File file2 = getBackOfficeDefaultFile();
        file2.setFileType(fileType);
        file2 = fileDao.save(file2);
        assertNotNull("File 2 id moet niet null zijn", file2.getId());
    }

    @Test
    @Transactional
    public void testFindFile() {
        // 1 filetype
        // 2 files
        Long fileId = getIdSavedFile();

        File file = fileDao.findOne(fileId);
        assertNotNull("File is null", file);
        assertTrue("FileSpecs mag nooit null zijn", file.getFileSpecs() != null);
        assertTrue("Gevonden naam moet 'file_name' zijn maar is: " + file.getFileSpecs().getFileName(), file.getFileSpecs().getFileName().equals("file_name"));

        FileType fileType = file.getFileType();
        assertNotNull("FileType mag nooit null zijn", fileType);
        assertTrue("FileType naam moet 'BackOfficeFileType' zijn maar is: " + fileType.getName(), fileType.getName().equals("BackOfficeFileType"));

        List<FileStatus> history = file.getHistory();
        assertNotNull("History is null", history);
        assertTrue("History zou 1 status moeten hebben. Het zijn er: " + history.size(), history.size() == 1);
    }

    @Test
    @Transactional
    public void testFindFileType() {
        // 1 filetype
        // 2 files
        Long fileId = getIdSavedFileType();

        assertTrue("Er zou nu 1 fileType moeten bestaan. Het zijn er: " + fileTypeDao.findAll().size(), fileTypeDao.findAll().size() == 1);
        assertTrue("Er zou 1 file moeten bestaan. Het zijn er: " + fileDao.findAll().size(), fileDao.findAll().size() == 1);

        FileType fileType = fileTypeDao.findOne(fileId);
        assertNotNull("fileType moet gevonden worden", fileType);
        assertTrue("Gevonden naam moet 'BackOfficeFileType' zijn", fileType.getName().equals("BackOfficeFileType"));

//        List<File> files = fileType.getFiles();
//        assertNotNull("Lijst met bestanden is null", files);
//        assertTrue("er zou 1 file moeten zijn maar het zijn er: " + files.stream().count(), files.stream().count() == 1);
    }

    private File getBackOfficeDefaultFile() {
        File file = new File();
        file.setFileSpecs(getFileSpecs());
        List<FileStatus> history = new ArrayList<>();
        history.add(getBackOfficeDefaultFileStatus());
        file.setHistory(history);
        return file;
    }

    private FileStatus getBackOfficeDefaultFileStatus() {
        FileStatus fileStatus = new FileStatus();
        fileStatus.setMoment(Calendar.getInstance().getTimeInMillis());
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
