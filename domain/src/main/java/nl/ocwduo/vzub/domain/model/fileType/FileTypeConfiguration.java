package nl.ocwduo.vzub.domain.model.fileType;

import nl.ocwduo.vzub.domain.model.fileType.details.EmailNotification;
import nl.ocwduo.vzub.domain.model.fileType.details.FileTimeManagement;
import nl.ocwduo.vzub.domain.model.fileType.details.GftKanaal;
import nl.ocwduo.vzub.domain.model.fileType.enums.fileKind;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by Machiel de Jager on 3-3-2016.
 */
@Entity
@Table(name = "File_Type_Configuration")
public class FileTypeConfiguration {

    // id
    @NotNull
    @Id
    private String name;

    private String discription;
    private String fileNameRegExpMatcher;

    // bevat alle wachttijden etc.
    @NotNull
    @OneToOne
    private FileTimeManagement fileTimeManagement;
    // in geval van customerfile
    @OneToOne
    private GftKanaal gftKanaal;
    // in geval van backoffice file
    @OneToOne
    private EmailNotification emailNotification;
    // onderscheidend vermogen: backoffice of customer file
    @NotNull
    private fileKind fileKind;
}