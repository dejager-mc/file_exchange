package nl.ocwduo.vzub.domain.model.configuration;

import nl.ocwduo.vzub.domain.model.configuration.enums.FileTypeType;

/**
 * Created by in434jag on 3-3-2016.
 */
public class fileType {

    // in geval van customerfile
    private GftKanaal gftKanaal;
    // in geval van backoffice file
    private EmailNotification emailNotification;
    // onderscheidend vermogen
    private FileTypeType fileTypeType;
}
