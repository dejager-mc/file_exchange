package nl.ocwduo.vzub.domain.model.fileType.details;

import nl.ocwduo.vzub.domain.model.fileType.FileType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by in434jag on 3-3-2016.
 */
@Entity
@Table(name = "FILE_TIME_MANAGEMENT")
public class FileTimeManagement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FILE_TIME_MANAGEMENT_ID")
    private Long id;
    @Column(name = "KEEP_FILE_FOR_DAYS", length = 4)
    private int keepFileForDays;
    @Column(name = "KEEP_FILE_AFTER_DOWNLOADING_FOR_DAYS", length = 4)
    private int keepFileAfterDownloadingForDays;
    @Column(name = "WAIT_FOR_SOMETHING_FOR_DAYS", length = 4)
    private int waitForSomethingForDays;    // TODO: nodig? naam aanpassen of weg

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
