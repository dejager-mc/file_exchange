package nl.ocwduo.vzub.domain;

import nl.ocwduo.vzub.domain.enums.CustomerFileStatus;

/**
 * Created by Machiel de Jager on 20-2-2016.
 */

/*
    Een bestand dat van de klant komt
 */
public class CustomerFile {
    private GftKanaal gftKanaal;
    private CustomerFileStatus status;

    private FileSpecs fileSpecs;
}
