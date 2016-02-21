package nl.ocwduo.vzub.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Machiel de Jager on 20-2-2016.
 */

/*
 * Bestand wordt onder andere, unieke, naam opgeslagen in de file share
 */
@Entity
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String readableName;
    private String storageName;
    private int fileSize;
//    private Dienst dienst;    // De dienst die gekoppeld is aan dit bestand

    protected File() {
    }

    public String getReadableName() {
        return readableName;
    }

    public void setReadableName(String readableName) {
        this.readableName = readableName;
    }

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public String toString() {
        return String.format("File[id=%d, readableName='%s', storageName='%s', fileSize=%d]", id, readableName, storageName, fileSize);
    }
}
