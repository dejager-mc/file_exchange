package nl.ocwduo.vzub.domain.model.file;

import nl.ocwduo.vzub.domain.model.file.details.FileLock;
import nl.ocwduo.vzub.domain.model.file.details.FileSpecs;
import nl.ocwduo.vzub.domain.model.file.details.FileStatus;
import nl.ocwduo.vzub.domain.model.fileType.FileTypeConfiguration;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Machiel de Jager on 20-2-2016.
 */

/*
    Een bestand dat vanuit de backoffice komt
 */
public class BackofficeFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length = 255)
    private String name;

    @NotNull
    @OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private FileSpecs fileSpecs;

    @NotNull
    @ManyToOne
    private FileTypeConfiguration fileTypeConfiguration;

    @OneToOne
    private FileLock fileLock;
    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private List<FileStatus> history;

    public FileLock getFileLock() {
        return fileLock;
    }

    public void setFileLock(FileLock fileLock) {
        this.fileLock = fileLock;
    }

    public FileSpecs getFileSpecs() {
        return fileSpecs;
    }

    public void setFileSpecs(FileSpecs fileSpecs) {
        this.fileSpecs = fileSpecs;
    }

    public FileTypeConfiguration getFileTypeConfiguration() {
        return fileTypeConfiguration;
    }

    public void setFileTypeConfiguration(FileTypeConfiguration fileTypeConfiguration) {
        this.fileTypeConfiguration = fileTypeConfiguration;
    }

    public List<FileStatus> getHistory() {
        return history;
    }

    public void setHistory(List<FileStatus> history) {
        this.history = history;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
