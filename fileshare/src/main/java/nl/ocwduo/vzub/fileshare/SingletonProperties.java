package nl.ocwduo.vzub.fileshare;

import org.springframework.beans.factory.annotation.Value;

import javax.ejb.Singleton;
import java.io.File;

/**
 * Created by Max Hunt on 24-3-2016.
 */
@Singleton
public class SingletonProperties {

    @Value("#{systemProperties.sftp.user}")
    private String user;
    @Value("#{systemProperties.sftp.user}")
    private String passphrase;
    @Value("#{systemProperties.sftp.user}")
    private String host;
    @Value("#{systemProperties.sftp.user}")
    private String rsaKeyFilePath;

    private File fileRsaKey;

    public File getFileRsaKey() {
        if (fileRsaKey == null) {
            return new File(rsaKeyFilePath);
        }
        return fileRsaKey;
    }

    private SingletonProperties() {
        // leeg
    }
}
