package nl.ocwduo.vzub.domain.model.fileConfig;

import nl.ocwduo.vzub.domain.model.fileConfig.details.EmailNotification;
import nl.ocwduo.vzub.domain.model.fileConfig.details.FileTimeManagement;
import nl.ocwduo.vzub.domain.model.fileConfig.details.GftKanaal;
import nl.ocwduo.vzub.domain.model.fileConfig.enums.fileKind;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by Machiel de Jager on 3-3-2016.
 */
@Entity
@Table
public class FileConfig {

    // id
    private String name;
    private String discription;
    private String fileNameRegExpMatcher;

    // bevat alle wachttijden etc.
    @OneToOne
    private FileTimeManagement fileTimeManagement;
    // in geval van customerfile
    @OneToOne
    private GftKanaal gftKanaal;
    // in geval van backoffice file
    @OneToOne
    private EmailNotification emailNotification;
    // onderscheidend vermogen: backoffice of customer file
    private fileKind fileKind;
}