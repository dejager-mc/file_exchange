package nl.ocwduo.vzub.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

/**
 * Created by Machiel de Jager on 20-2-2016.
 */

/*
    Een bestand vanuit de backoffice komt
 */
public class BackofficeFile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private EmailNotification emailNotification;

    private List<FileStatus> history;

    private FileSpecs fileSpecs;
}
