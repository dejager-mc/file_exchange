package nl.ocwduo.vzub.domain.model.file.details;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Machiel de Jager on 20-2-2016.
 */

/*
 *
 */
@Entity
@Table(name = "File_Specs")
public class FileSpecs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 255)
    @NotNull
    private String fileName;
    @Column(length = 1024)
    @NotNull
    private String filePath;
    @Column(length = 20)
    @NotNull
    private long fileSize;
    @OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval = true)

    private Long creationDateTime;



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
