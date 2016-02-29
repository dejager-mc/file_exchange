package nl.ocwduo.vzub.domain;

import javax.persistence.*;

/**
 * Created by Machiel de Jager on 28-2-2016.
 */

/*
    Sommige processen willen mogelijk een lock leggen op een / een aantal bestanden
    Dat kan via deze entity.
 */
@Entity
@Table
public class FileLock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @OneToOne
    private FileSpecs fileSpecs;
    @Column(length = 50)
    private String lockerId;    // welke machine / thread de locks heeft gelegd
    @Column(length = 20)
    private Long lockMoment;
    @Column(length = 50)
    private String lockerProces;
}
