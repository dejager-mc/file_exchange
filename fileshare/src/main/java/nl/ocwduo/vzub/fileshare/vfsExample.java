package nl.ocwduo.vzub.fileshare;

import com.jcraft.jsch.UserInfo;
import org.apache.commons.vfs2.*;
import org.apache.commons.vfs2.auth.StaticUserAuthenticator;
import org.apache.commons.vfs2.impl.DefaultFileSystemConfigBuilder;
import org.apache.commons.vfs2.impl.StandardFileSystemManager;
import org.apache.commons.vfs2.provider.sftp.SftpFileSystemConfigBuilder;
import org.omg.SendingContext.RunTime;

import java.io.File;
import java.io.IOException;

/**
 * The class SFTPUtil containing uploading, downloading, checking if file exists
 * and deleting functionality using Apache Commons VFS (Virtual File System)
 * Library
 *
 * @author Ashok
 */
public class vfsExample {

    public static void main(String[] args) {
        String hostName = "172.30.248.31:22";
        String username = "zpuserwas";
        String password = "caramelchew";

        String localFilePath = "D:\\JAVA\\Projects\\VZUB_JI\\workspaces\\herbouw\\file_exchange\\scripts\\fileshare\\readme.txt";
        String remoteFilePath = "bestandsuitwisseling/bestanden/FakeRemoteFile.txt";
        String remoteTempFilePath = "bestandsuitwisseling/bestanden/FakeRemoteTempFile.txt";

        try {
            init(hostName, username, password, localFilePath, remoteFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        upload(hostName, username, password, localFilePath, remoteFilePath);
//        exist(hostName, username, password, remoteFilePath);
//        download(hostName, username, password, localFilePath,remoteFilePath);
//        move(hostName, username, password, remoteFilePath, remoteTempFilePath);
//        delete(hostName, username, password, remoteFilePath);
    }

    public static void init(String hostName, String username, String passphraseRsaKey, String localFilePath, String remoteFilePath) throws IOException {
        try {
            StaticUserAuthenticator auth = new StaticUserAuthenticator(hostName, username, passphraseRsaKey);

            File fileRsaKey = new File("D:\\JAVA\\Projects\\VZUB_JI\\workspaces\\herbouw\\file_exchange\\scripts\\fileshare\\id_dsa_zpuserwas_fat.ppk");

            if (fileRsaKey == null || !fileRsaKey.exists()) {
                throw new IllegalArgumentException("RSA-key-file  bestaat niet.");
            }

            FileSystemOptions options = new FileSystemOptions();
            DefaultFileSystemConfigBuilder.getInstance().setUserAuthenticator(options, auth);
            SftpFileSystemConfigBuilder.getInstance().setUserInfo(options, new SftpPassphraseUserInfo(passphraseRsaKey));
            SftpFileSystemConfigBuilder.getInstance().setIdentities(options, new File[]{fileRsaKey});
            SftpFileSystemConfigBuilder.getInstance().setPreferredAuthentications(options, "publickey");
            FileSystemManager vfsManager = VFS.getManager();
            System.out.println("init success");


//            FileObject fakeFile = vfsManager.resolveFile("sftp://172.30.248.31/bestandsuitwisseling/bestanden/" + "FakeRemoteFile.txt", options);
//            System.out.println("connection success");
//
//            File file = new File(localFilePath);
//            FileObject localFile = vfsManager.resolveFile(file.getAbsolutePath());
//
//            fakeFile.copyFrom(localFile, Selectors.SELECT_SELF);
//            fakeFile.close();
//            localFile.close();

            FileObject deleteFile = vfsManager.resolveFile("sftp://172.30.248.31/bestandsuitwisseling/bestanden/" + "FakeRemoteFile.txt", options);
            deleteFile.delete(Selectors.SELECT_SELF);
            deleteFile.close();

//            StandardFileSystemManager standardFileSystemManager = new StandardFileSystemManager();
//            standardFileSystemManager.init();
//            this.vfsManager = standardFileSystemManager;
        } catch (IOException e) {
            System.out.println("IO Exception");
            throw new RuntimeException(e);
            // rethrow
        } finally {

        }
    }

    public static FileObject getFileObject(FileSystemManager vfsManager, String fileName, FileSystemOptions options) throws FileSystemException {
        return vfsManager.resolveFile("/bestandsuitwisseling/bestanden/" + fileName, options);
    }

    /**
     * Method to upload a file in Remote server
     *
     * @param hostName       HostName of the server
     * @param username       UserName to login
     * @param password       Password to login
     * @param localFilePath  LocalFilePath. Should contain the entire local file path -
     *                       Directory and Filename with \\ as separator
     * @param remoteFilePath remoteFilePath. Should contain the entire remote file path -
     *                       Directory and Filename with / as separator
     */
    public static void upload(String hostName, String username, String password, String localFilePath, String remoteFilePath) {

        File file = new File(localFilePath);
        if (!file.exists())
            throw new RuntimeException("Error. Local file not found");

        StandardFileSystemManager manager = new StandardFileSystemManager();

        try {
            manager.init();

            // Create local file object
            FileObject localFile = manager.resolveFile(file.getAbsolutePath());

            // Create remote file object
            FileObject remoteFile = manager.resolveFile(createConnectionString(hostName, username, password, remoteFilePath), createDefaultOptions());
            /*
             * use createDefaultOptions() in place of fsOptions for all default
             * options - Ashok.
             */

            // Copy local file to sftp server
            remoteFile.copyFrom(localFile, Selectors.SELECT_SELF);

            System.out.println("File upload success");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            manager.close();
        }
    }

    public static boolean move(String hostName, String username, String password, String remoteSrcFilePath, String remoteDestFilePath) {
        StandardFileSystemManager manager = new StandardFileSystemManager();

        try {
            manager.init();

            // Create remote object
            FileObject remoteFile = manager.resolveFile(createConnectionString(hostName, username, password, remoteSrcFilePath), createDefaultOptions());
            FileObject remoteDestFile = manager.resolveFile(createConnectionString(hostName, username, password, remoteDestFilePath), createDefaultOptions());

            if (remoteFile.exists()) {
                remoteFile.moveTo(remoteDestFile);
                ;
                System.out.println("Move remote file success");
                return true;
            } else {
                System.out.println("Source file doesn't exist");
                return false;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            manager.close();
        }
    }

    /**
     * Method to download the file from remote server location
     *
     * @param hostName       HostName of the server
     * @param username       UserName to login
     * @param password       Password to login
     * @param localFilePath  LocalFilePath. Should contain the entire local file path -
     *                       Directory and Filename with \\ as separator
     * @param remoteFilePath remoteFilePath. Should contain the entire remote file path -
     *                       Directory and Filename with / as separator
     */
    public static void download(String hostName, String username, String password, String localFilePath, String remoteFilePath) {

        StandardFileSystemManager manager = new StandardFileSystemManager();

        try {
            manager.init();

            // Append _downlaod_from_sftp to the given file name.
            //String downloadFilePath = localFilePath.substring(0, localFilePath.lastIndexOf(".")) + "_downlaod_from_sftp" + localFilePath.substring(localFilePath.lastIndexOf("."), localFilePath.length());

            // Create local file object. Change location if necessary for new downloadFilePath
            FileObject localFile = manager.resolveFile(localFilePath);

            // Create remote file object
            FileObject remoteFile = manager.resolveFile(createConnectionString(hostName, username, password, remoteFilePath), createDefaultOptions());

            // Copy local file to sftp server
            localFile.copyFrom(remoteFile, Selectors.SELECT_SELF);

            System.out.println("File download success");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            manager.close();
        }
    }

    /**
     * Method to delete the specified file from the remote system
     *
     * @param hostName       HostName of the server
     * @param username       UserName to login
     * @param password       Password to login
     * @param remoteFilePath remoteFilePath. Should contain the entire remote file path -
     *                       Directory and Filename with / as separator
     */
    public static void delete(String hostName, String username, String password, String remoteFilePath) {
        StandardFileSystemManager manager = new StandardFileSystemManager();

        try {
            manager.init();

            // Create remote object
            FileObject remoteFile = manager.resolveFile(createConnectionString(hostName, username, password, remoteFilePath), createDefaultOptions());

            if (remoteFile.exists()) {
                remoteFile.delete();
                System.out.println("Delete remote file success");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            manager.close();
        }
    }

    // Check remote file is exist function:

    /**
     * Method to check if the remote file exists in the specified remote
     * location
     *
     * @param hostName       HostName of the server
     * @param username       UserName to login
     * @param password       Password to login
     * @param remoteFilePath remoteFilePath. Should contain the entire remote file path -
     *                       Directory and Filename with / as separator
     * @return Returns if the file exists in the specified remote location
     */
    public static boolean exist(String hostName, String username, String password, String remoteFilePath) {
        StandardFileSystemManager manager = new StandardFileSystemManager();

        try {
            manager.init();

            // Create remote object
            FileObject remoteFile = manager.resolveFile(createConnectionString(hostName, username, password, remoteFilePath), createDefaultOptions());

            System.out.println("File exist: " + remoteFile.exists());

            return remoteFile.exists();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            manager.close();
        }
    }

    /**
     * Generates SFTP URL connection String
     *
     * @param hostName       HostName of the server
     * @param username       UserName to login
     * @param password       Password to login
     * @param remoteFilePath remoteFilePath. Should contain the entire remote file path -
     *                       Directory and Filename with / as separator
     * @return concatenated SFTP URL string
     */
    public static String createConnectionString(String hostName, String username, String password, String remoteFilePath) {
        // we gebruiken een passphrase dus geen password
//        return "sftp://" + username + ":" + password + "@" + hostName + "/" + remoteFilePath;
        return "sftp://" + username + "@" + hostName + "/" + remoteFilePath;
    }

    /**
     * Method to setup default SFTP config
     *
     * @return the FileSystemOptions object containing the specified
     * configuration options
     * @throws FileSystemException
     */
    public static FileSystemOptions createDefaultOptions() throws FileSystemException {
        // Create SFTP options
        FileSystemOptions options = new FileSystemOptions();

        // SSH Key checking
        SftpFileSystemConfigBuilder.getInstance().setStrictHostKeyChecking(options, "no");
        SftpFileSystemConfigBuilder.getInstance().setUserInfo(options, new SftpPassphraseUserInfo("passphrase"));

        File zpuserwas_fat_ppk = new File("D:\\JAVA\\Projects\\VZUB_JI\\workspaces\\herbouw\\file_exchange\\scripts\\fileshare\\id_dsa_zpuserwas_fat.ppk");

        SftpFileSystemConfigBuilder.getInstance().setIdentities(options, new File[]{zpuserwas_fat_ppk}); // ppk "file"

        /*
         * Using the following line will cause VFS to choose File System's Root
         * as VFS's root. If I wanted to use User's home as VFS's root then set
         * 2nd method parameter to "true"
         */
        // Root directory set to user home
        SftpFileSystemConfigBuilder.getInstance().setUserDirIsRoot(options, false);

        // Timeout is count by Milliseconds
        SftpFileSystemConfigBuilder.getInstance().setTimeout(options, 10000);

        return options;
    }

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

