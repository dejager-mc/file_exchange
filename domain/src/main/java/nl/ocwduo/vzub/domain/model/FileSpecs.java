package nl.ocwduo.vzub.domain.model;

import javax.persistence.*;

/**
 * Created by Machiel de Jager on 20-2-2016.
 */

/*
 *
 */
@Entity
@Table
public class FileSpecs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 255)
    private String fileName;
    @Column(length = 1024)
    private String filePath;
    @Column(length = 20)
    private long fileSize;
    @OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private FileLock fileLock;

    protected FileSpecs() {
    }



    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public String toString() {
        return String.format("FileSpecs[id=%d, fileName='%s', fileSize=%d]", id, fileName, fileSize);
    }
}
