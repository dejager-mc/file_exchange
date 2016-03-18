package nl.ocwduo.vzub.fileshare;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.vfs2.FileSystemException;
import org.apache.commons.vfs2.FileSystemManager;
import org.apache.commons.vfs2.VFS;
import org.apache.commons.vfs2.impl.StandardFileSystemManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
