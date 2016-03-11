package nl.ocwduo.vzub.domain.model.file.details;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Machiel de Jager on 26-2-2016.
 */
@Entity
@Table(name = "FILE_STATUS")
public class FileStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FILE_STATUS_ID")
    private Long id;
    @Column(length = 30)
    @NotNull
    private String status;
    @Column(length = 20)
    @NotNull
    private Long moment;


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
