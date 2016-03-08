package nl.ocwduo.vzub.domain.fileshare;

import java.io.InputStream;

/**
 * Created by Max Hunt on 21-2-2016.
 */
public interface FileShareServiceInterface {
//    void plaatsBackendFile(File file);
//
//    OutputStream streamFileToUser(FileSpecs file);

    void uploadFile(InputStream stream);
}
