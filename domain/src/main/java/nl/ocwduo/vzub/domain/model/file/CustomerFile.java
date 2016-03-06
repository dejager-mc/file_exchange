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
    Een bestand dat van de klant komt
 */
@Entity
@Table(name = "Customer_File")
public class CustomerFile {
    @Id
    private long id;
    @NotNull
    private String name;

    @OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private FileSpecs fileSpecs;

    @NotNull
    private FileLock fileLock;
    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL, mappedBy = "filespecs")
    private List<FileStatus> history;

    @ManyToOne
    private FileTypeConfiguration fileTypeConfiguration;

}
