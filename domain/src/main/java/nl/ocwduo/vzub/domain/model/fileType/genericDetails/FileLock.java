package nl.ocwduo.vzub.domain.model.fileType.genericDetails;

import nl.ocwduo.vzub.domain.model.theFile.FileSpecs;

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
@Table(name = "File_Lock")
public class FileLock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @OneToOne(orphanRemoval = false, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @NotNull
    private FileSpecs fileSpecs;
    @Column(length = 50)
    @NotNull
    private String lockerId;    // welke machine / thread de locks heeft gelegd
    @Column(length = 20)
    @NotNull
    private Long lockMoment;
    @Column(length = 50)
    @NotNull
    private String lockerProces;
}
