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
public class FileSpecs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private int fileSize;

    protected FileSpecs() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public String toString() {
        return String.format("FileSpecs[id=%d, name='%s', fileSize=%d]", id, name, fileSize);
    }
}
