package nl.ocwduo.vzub.domain.model.fileConfig;

import nl.ocwduo.vzub.domain.model.fileConfig.details.EmailNotification;
import nl.ocwduo.vzub.domain.model.fileConfig.details.FileTimeManagement;
import nl.ocwduo.vzub.domain.model.fileConfig.details.GftKanaal;
import nl.ocwduo.vzub.domain.model.fileConfig.enums.fileKind;

/**
 * Created by in434jag on 3-3-2016.
 */
public class FileConfig {

    private String name;
    private String discription;
    private String fileNameRegExpMatcher;


    // bevat alle wachttijden etc.
    private FileTimeManagement fileTimeManagement;
    // in geval van customerfile
    private GftKanaal gftKanaal;
    // in geval van backoffice file
    private EmailNotification emailNotification;
    // onderscheidend vermogen: backoffice of customer file
    private fileKind fileKind;
}