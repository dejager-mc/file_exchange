package nl.ocwduo.vzub.domain.model.file;

import nl.ocwduo.vzub.domain.model.file.details.FileLock;
import nl.ocwduo.vzub.domain.model.file.details.FileSpecs;
import nl.ocwduo.vzub.domain.model.file.details.FileStatus;
import nl.ocwduo.vzub.domain.model.fileType.FileTypeConfiguration;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Machiel de Jager on 20-2-2016.
 */

/*
    Een bestand dat vanuit de backoffice komt
 */
@Entity
@Table(name = "Backoffice_File")
public class BackofficeFile {

    @Id
    private long id;

    @NotNull
    private String name;

    @OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private FileSpecs fileSpecs;

    @ManyToOne
    private FileTypeConfiguration fileTypeConfiguration;

//    private Dienst dienst;
// bij het aanmaken van deze entiteit wordt de opgegeven organisatie
    // in het gft bericht gecontroleerd of deze hoort bij een FileTypeConfiguration

    @OneToOne
    private FileLock fileLock;
    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL, mappedBy = "filespecs")
    private List<FileStatus> history;
}
