package nl.ocwduo.vzub.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Machiel de Jager on 20-2-2016.
 */

/*
    Een bestand vanuit de backoffice komt
 */
@Entity
public class BackofficeFile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    private EmailNotification emailNotification;

    @OneToMany
    private List<FileStatus> history;

    @OneToOne
    private FileSpecs fileSpecs;
}
