package nl.ocwduo.vzub.domain;

import nl.ocwduo.vzub.domain.enums.BackofficeFileStatus;

/**
 * Created by Machiel de Jager on 20-2-2016.
 */

/*
    Een bestand vanuit de backoffice komt
 */
public class BackofficeFile {
    private EmailNotification emailNotification;
    private BackofficeFileStatus status;


    private FileSpecs fileSpecs;
}
