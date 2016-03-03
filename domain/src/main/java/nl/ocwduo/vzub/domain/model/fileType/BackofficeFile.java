package nl.ocwduo.vzub.domain.model.fileType;

import nl.ocwduo.vzub.domain.model.configuration.EmailNotification;
import nl.ocwduo.vzub.domain.model.fileType.genericDetails.Dienst;
import nl.ocwduo.vzub.domain.model.theFile.FileSpecs;

import javax.persistence.*;

/**
 * Created by Machiel de Jager on 20-2-2016.
 */

/*
    Een bestand dat vanuit de backoffice komt
 */
@Entity
@Table(name = "Backoffice_File")
public class BackofficeFile {


    // id
    private String name;

    @OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private EmailNotification emailNotification;

    @OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private FileSpecs fileSpecs;

    private Dienst dienst;

    public EmailNotification getEmailNotification() {
        return emailNotification;
    }

    public void setEmailNotification(EmailNotification emailNotification) {
        this.emailNotification = emailNotification;
    }

    public FileSpecs getFileSpecs() {
        return fileSpecs;
    }

    public void setFileSpecs(FileSpecs fileSpecs) {
        this.fileSpecs = fileSpecs;
    }

}
