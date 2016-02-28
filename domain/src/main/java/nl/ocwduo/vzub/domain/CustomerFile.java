package nl.ocwduo.vzub.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Machiel de Jager on 20-2-2016.
 */

/*
    Een bestand dat van de klant komt
 */
@Entity
public class CustomerFile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    private GftKanaal gftKanaal;
    @OneToMany
    private List<FileStatus> history;
    @OneToOne
    private FileSpecs fileSpecs;

    //    private Dienst dienst;    // De dienst die gekoppeld is aan dit bestand
}
