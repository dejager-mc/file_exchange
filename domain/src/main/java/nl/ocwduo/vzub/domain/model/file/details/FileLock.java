package nl.ocwduo.vzub.domain.model.file.details;

import nl.ocwduo.vzub.domain.model.file.File;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Machiel de Jager on 28-2-2016.
 */

/*
    Sommige processen willen mogelijk een lock leggen op een / een aantal bestanden
    Dat kan via deze entity.
 */
@Entity
@Table(name = "FILE_LOCK")
public class FileLock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FILE_LOCK_ID")
    private Long id;
    @Column(name = "LOCK_MOMENT", length = 20)
    @NotNull
    private Long lockMoment;
    @Column(name = "LOCKER_PROCES", length = 50)
    @NotNull
    private String lockerProces;
    @NotNull
    @Column(name = "LOCKER_ID", length = 50)
    private String lockerId;    // welke machine / thread de lock heeft gelegt

    public Long getId() {
        return id;
    }

    public String getLockerId() {
        return lockerId;
    }

    public void setLockerId(String lockerId) {
        this.lockerId = lockerId;
    }

    public String getLockerProces() {
        return lockerProces;
    }

    public void setLockerProces(String lockerProces) {
        this.lockerProces = lockerProces;
    }

    public Long getLockMoment() {
        return lockMoment;
    }

    public void setLockMoment(Long lockMoment) {
        this.lockMoment = lockMoment;
    }
}
