package nl.ocwduo.vzub.domain.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Machiel de Jager on 20-2-2016.
 */

/*
    Een bestand dat vanuit de backoffice komt
 */
@Entity
@Table(name = "BACKOFFICEFILE")
public class BackofficeFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private EmailNotification emailNotification;

    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private List<FileStatus> history;

    @OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private FileSpecs fileSpecs;

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

    public List<FileStatus> getHistory() {
        return history;
    }

    public void setHistory(List<FileStatus> history) {
        this.history = history;
    }

    public long getId() {
        return id;
    }
}
