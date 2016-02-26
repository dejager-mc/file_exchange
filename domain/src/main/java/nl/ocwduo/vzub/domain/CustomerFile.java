package nl.ocwduo.vzub.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

/**
 * Created by Machiel de Jager on 20-2-2016.
 */

/*
    Een bestand dat van de klant komt
 */
public class CustomerFile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private GftKanaal gftKanaal;
    private List<FileStatus> history;

    private FileSpecs fileSpecs;

    //    private Dienst dienst;    // De dienst die gekoppeld is aan dit bestand
}
