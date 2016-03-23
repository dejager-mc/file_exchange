package nl.ocwduo.vzub.fileshare;

import com.jcraft.jsch.UserInfo;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.vfs2.*;
import org.apache.commons.vfs2.auth.StaticUserAuthenticator;
import org.apache.commons.vfs2.impl.DefaultFileSystemConfigBuilder;
import org.apache.commons.vfs2.impl.StandardFileSystemManager;

import org.apache.commons.vfs2.provider.sftp.SftpFileSystemConfigBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.InputStream;

/**
 * Created by Machiel de Jager on 18-3-2016.
 */
public class vfsHelper {

    private static Logger LOGGER = LoggerFactory.getLogger(vfsHelper.class);

    @Value("#{systemProperties.sftp.user}")
    private String user;
    @Value("#{systemProperties.sftp.user}")
    private String passphrase;
    @Value("#{systemProperties.sftp.user}")
    private String host;
    @Value("#{systemProperties.sftp.user}")
    private String rsaKeyFilePath;

    public void moveFile() {

    }

    public void getFileInputStream() {

    }

    public void getFileOutputStream() {

    }

    public void uploadGuiFileToFileServer(InputStream inputStream) {

    }

    public void deleteFile(String filePath) {
        FileObject deleteFile = null;
        try {
//            deleteFile = ((FileSystemManager) fileSystemManager.get()).resolveFile("sftp://172.30.248.31/bestandsuitwisseling/bestanden/" + "FakeRemoteFile.txt", getFileSystemOptionsDuo());
            deleteFile = ((FileSystemManager) fileSystemManager.get()).resolveFile(filePath, getFileSystemOptionsDuo());
            deleteFile.delete(Selectors.SELECT_SELF);
            deleteFile.close();
        } catch (FileSystemException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param serverUrl sftp://172.30.248.31/
     * @param rootPath  bestandsuitwisseling/bestanden/
     * @param path
     * @param fileName
     */
    private void createNewFileOnFileShare(String serverUrl, String rootPath, String path, String fileName) {
        FileSystemManager fsManager = (FileSystemManager) fileSystemManager.get();
        FileObject fileObject = null;
        try {
            fileObject = fsManager.resolveFile(serverUrl + rootPath + path + "/" + fileName);
        } catch (FileSystemException e) {
            e.printStackTrace();
        } finally {
            closeFileObject(fileObject);
        }
    }

    private void closeFileObject(FileObject fileObject) {
        if (fileObject != null) {
            try {
                fileObject.close();
            } catch (FileSystemException e) {
                e.printStackTrace();
            }
        }
    }

    public static FileObject getFileObject(FileSystemManager vfsManager, String fileName, FileSystemOptions options) throws FileSystemException {
        return vfsManager.resolveFile("/bestandsuitwisseling/bestanden/" + fileName, options);
    }

    private FileSystemOptions getFileSystemOptionsDuo() {
        return getFileSystemOptions(host, user, passphrase, rsaKeyFilePath);
    }

    /**
     * @param hostName
     * @param userName
     * @param passphraseRsaKey
     * @param rsaKeyFilePath
     * @return
     */
    private FileSystemOptions getFileSystemOptions(String hostName, String userName, String passphraseRsaKey, String rsaKeyFilePath) {
        StaticUserAuthenticator auth = new StaticUserAuthenticator(hostName, userName, passphraseRsaKey);

//        File fileRsaKey = new File("D:\\JAVA\\Projects\\VZUB_JI\\workspaces\\herbouw\\file_exchange\\scripts\\fileshare\\id_dsa_zpuserwas_fat.ppk");
        /*
            FIXME Nu wordt elke keer het bestand uitgelezen
         */
        File fileRsaKey = getFileRsaKey(rsaKeyFilePath);

        FileSystemOptions options = new FileSystemOptions();
        try {
            DefaultFileSystemConfigBuilder.getInstance().setUserAuthenticator(options, auth);
            SftpFileSystemConfigBuilder.getInstance().setUserInfo(options, new SftpPassphraseUserInfo(passphraseRsaKey));
            SftpFileSystemConfigBuilder.getInstance().setIdentities(options, new File[]{fileRsaKey});
            SftpFileSystemConfigBuilder.getInstance().setPreferredAuthentications(options, "publickey");
        } catch (FileSystemException e) {
            e.printStackTrace();
        }

        return options;
    }

    private File getFileRsaKey(String path) {
        File fileRsaKey = new File(path);

        if (fileRsaKey == null || !fileRsaKey.exists()) {
            throw new IllegalArgumentException("RSA-key-file  bestaat niet.");
        }

        return fileRsaKey;
    }

    private static final ThreadLocal fileSystemManager = new ThreadLocal() {
        @Override
        protected FileSystemManager initialValue() {
            StandardFileSystemManager standardFileSystemManager = new StandardFileSystemManager();
            standardFileSystemManager.setLogger(LogFactory.getLog(VFS.class));

            try {
                standardFileSystemManager.init();
            } catch (FileSystemException e) {
                LOGGER.error("Could not initialize thread-local FileSystemManager.", e);
            }

            return standardFileSystemManager;
        }
    };

    public static class SftpPassphraseUserInfo implements UserInfo {

        private String passphrase = null;

        public SftpPassphraseUserInfo(final String pp) {
            passphrase = pp;
        }

        public String getPassphrase() {
            return passphrase;
        }

        public String getPassword() {
            return null;
        }

        public boolean promptPassphrase(String arg0) {
            return true;
        }

        public boolean promptPassword(String arg0) {
            return false;
        }

        public void showMessage(String message) {

        }

        public boolean promptYesNo(String str) {
            return true;
        }

    }
}
