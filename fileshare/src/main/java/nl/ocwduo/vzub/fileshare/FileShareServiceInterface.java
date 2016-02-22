package nl.ocwduo.vzub.fileshare;

import nl.ocwduo.vzub.domain.FileSpecs;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Max Hunt on 21-2-2016.
 */
public interface FileShareServiceInterface {
    void plaatsBackendFile(FileSpecs file);

    OutputStream streamFileToUser(FileSpecs file);

    void uploadFile(InputStream stream);
}
