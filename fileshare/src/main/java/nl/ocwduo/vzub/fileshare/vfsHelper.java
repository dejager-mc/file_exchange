package nl.ocwduo.vzub.fileshare;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemException;
import org.apache.commons.vfs2.FileSystemManager;
import org.apache.commons.vfs2.VFS;
import org.apache.commons.vfs2.impl.StandardFileSystemManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;

/**
 * Created by Machiel de Jager on 18-3-2016.
 */
public class vfsHelper {

    private static Logger LOGGER = LoggerFactory.getLogger(vfsHelper.class);

    public void moveFile() {

    }

    public void getFileInputStream() {

    }

    public void getFileOutputStream() {

    }

    public void uploadGuiFileToFileServer(InputStream inputStream) {

    }

    /**
     *
     * @param serverUrl sftp://172.30.248.31/
     * @param rootPath bestandsuitwisseling/bestanden/
     * @param path
     * @param fileName
     */
    private void createNewFileOnFileShare(String serverUrl, String rootPath, String path, String fileName) {
        FileSystemManager fsManager = (FileSystemManager)fileSystemManager.get();
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
}
