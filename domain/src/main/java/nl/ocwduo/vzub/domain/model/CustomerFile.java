package nl.ocwduo.vzub.domain.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Machiel de Jager on 20-2-2016.
 */

/*
    Een bestand dat van de klant komt
 */
@Entity
@Table(name = "CUSTOMERFILE")
public class CustomerFile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private GftKanaal gftKanaal;
    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private List<FileStatus> history;
    @OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private FileSpecs fileSpecs;

    //    private Dienst dienst;    // De dienst die gekoppeld is aan dit bestand
}
