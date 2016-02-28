package nl.ocwduo.vzub.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Machiel de Jager on 28-2-2016.
 */

/*
    Sommige processen willen mogelijk een lock leggen op een / een aantal bestanden
    Dat kan via deze entity.
 */
@Entity
public class FileLock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Long fileSpecsId;
    private String lockerId;    // welke machine / thread de locks heeft gelegd
    private Long lockMoment;
    private String lockerProces;
}
