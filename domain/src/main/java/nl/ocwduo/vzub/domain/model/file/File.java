package nl.ocwduo.vzub.domain.model.file;

import nl.ocwduo.vzub.domain.model.file.details.FileLock;
import nl.ocwduo.vzub.domain.model.file.details.FileSpecs;
import nl.ocwduo.vzub.domain.model.file.details.FileStatus;
import nl.ocwduo.vzub.domain.model.fileType.FileTypeConfiguration;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by in434jag on 7-3-2016.
 */

@Entity
@Table(name = "File")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
}
