package nl.ocwduo.vzub.domain.model.file.details;

import nl.ocwduo.vzub.domain.model.file.File;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Machiel de Jager on 26-2-2016.
 */
@Entity
@Table(name = "File_Status")
public class FileStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "File_Status_ID")
    private Long id;
    @Column(length = 30)
    @NotNull
    private String status;
    @Column(length = 20)
    @NotNull
    private Long moment;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "File_ID")
    private File file;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public long getId() {
        return id;
    }

    public Long getMoment() {
        return moment;
    }

    public void setMoment(Long moment) {
        this.moment = moment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
