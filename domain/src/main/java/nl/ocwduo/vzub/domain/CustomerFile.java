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
@Table(name = "CUS_FILE")
public class CustomerFile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(fetch = FetchType.EAGER)
    private GftKanaal gftKanaal;
    @OneToMany(fetch = FetchType.EAGER)
    private List<FileStatus> history;
    @OneToOne(fetch = FetchType.EAGER)
    private FileSpecs fileSpecs;

    //    private Dienst dienst;    // De dienst die gekoppeld is aan dit bestand
}
