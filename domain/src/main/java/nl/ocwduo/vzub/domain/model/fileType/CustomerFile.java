package nl.ocwduo.vzub.domain.model.fileType;

import nl.ocwduo.vzub.domain.model.fileType.genericDetails.Dienst;
import nl.ocwduo.vzub.domain.model.theFile.FileSpecs;
import nl.ocwduo.vzub.domain.model.configuration.GftKanaal;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Machiel de Jager on 20-2-2016.
 */

/*
    Een bestand dat van de klant komt
 */
@Entity
@Table(name = "Customer_File")
public class CustomerFile {
    // id
    private String name;

    @OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @NotNull
    private GftKanaal gftKanaal;

    @OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private FileSpecs fileSpecs;

    private Dienst dienst;

    private String nameMatchingRegExp;  // requirement vanuit de backoffice

    private int processingDelay;
}
