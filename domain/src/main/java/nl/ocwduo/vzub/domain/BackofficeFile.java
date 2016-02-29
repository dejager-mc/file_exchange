package nl.ocwduo.vzub.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Machiel de Jager on 20-2-2016.
 */

/*
    Een bestand dat vanuit de backoffice komt
 */
@Entity
@Table(name = "BO_FILE")
public class BackofficeFile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(fetch = FetchType.EAGER)
    private EmailNotification emailNotification;

    @OneToMany(fetch = FetchType.EAGER)
    private List<FileStatus> history;

    @OneToOne(fetch = FetchType.EAGER)
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
