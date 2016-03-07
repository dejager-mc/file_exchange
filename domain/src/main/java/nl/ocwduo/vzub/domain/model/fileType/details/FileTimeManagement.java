package nl.ocwduo.vzub.domain.model.fileType.details;

import nl.ocwduo.vzub.domain.model.fileType.FileTypeConfiguration;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by in434jag on 3-3-2016.
 */
@Entity
@Table(name = "File_Time_Management")
public class FileTimeManagement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @NotNull
    private FileTypeConfiguration fileTypeConfiguration;

    @Column(length = 4)
    private int keepFileForDays;
    @Column(length = 4)
    private int keepFileAfterDownloadingForDays;
    @Column(length = 4)
    private int waitForSomethingForDays;

    public FileTypeConfiguration getFileTypeConfiguration() {
        return fileTypeConfiguration;
    }

    public void setFileTypeConfiguration(FileTypeConfiguration fileTypeConfiguration) {
        this.fileTypeConfiguration = fileTypeConfiguration;
    }

    public Long getId() {
        return id;
    }

    public int getKeepFileAfterDownloadingForDays() {
        return keepFileAfterDownloadingForDays;
    }

    public void setKeepFileAfterDownloadingForDays(int keepFileAfterDownloadingForDays) {
        this.keepFileAfterDownloadingForDays = keepFileAfterDownloadingForDays;
    }

    public int getKeepFileForDays() {
        return keepFileForDays;
    }

    public void setKeepFileForDays(int keepFileForDays) {
        this.keepFileForDays = keepFileForDays;
    }

    public int getWaitForSomethingForDays() {
        return waitForSomethingForDays;
    }

    public void setWaitForSomethingForDays(int waitForSomethingForDays) {
        this.waitForSomethingForDays = waitForSomethingForDays;
    }
}
