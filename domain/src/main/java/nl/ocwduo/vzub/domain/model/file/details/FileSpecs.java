package nl.ocwduo.vzub.domain.model.file.details;

import nl.ocwduo.vzub.domain.model.file.File;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 255)
    @NotNull
    private String fileName;
    @Column(length = 1024)
    @NotNull
    private String filePath;
    @Column(length = 20)
    @NotNull
    private Long fileSize;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public Long getId() {
        return id;
    }
}
