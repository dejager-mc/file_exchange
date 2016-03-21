package nl.ocwduo.vzub.domain.model.fileType;

import nl.ocwduo.vzub.domain.model.fileType.details.EmailNotification;
import nl.ocwduo.vzub.domain.model.fileType.details.FileTimeManagement;
import nl.ocwduo.vzub.domain.model.fileType.details.GftKanaal;
import nl.ocwduo.vzub.domain.model.fileType.details.Organisatie;
import nl.ocwduo.vzub.domain.model.fileType.enums.FileKind;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Machiel de Jager on 3-3-2016.
 */
@Entity
@Table(name = "FILE_TYPE")
public class FileType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FILE_TYPE_ID")
    private Long id;

    @Column(length = 20,unique = true, nullable = false)
    private String name;

    @Column(length = 500, nullable = false)
    private String discription;
    @Column(name = "FILE_NAME_REGEXP_MATCHER", length = 255)
    private String fileNameRegExpMatcher;

    @NotNull
    @OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    private FileTimeManagement fileTimeManagement;
    // in geval van customerfile
    @ManyToOne(fetch = FetchType.EAGER)
    private GftKanaal gftKanaal;
    // in geval van backoffice file
    @OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    private EmailNotification emailNotification;

    // onderscheidend vermogen: backoffice of customer file
    @Column(name = "File_Kind", nullable = false)
    private FileKind fileKind;

    @OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    private Organisatie organisatie;


    public Organisatie getOrganisatie() {
        return organisatie;
    }

    public void setOrganisatie(Organisatie organisatie) {
        this.organisatie = organisatie;
    }

    public Long getId() {
        return id;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public EmailNotification getEmailNotification() {
        return emailNotification;
    }

    public void setEmailNotification(EmailNotification emailNotification) {
        this.emailNotification = emailNotification;
    }

    public FileKind getFileKind() {
        return fileKind;
    }

    public void setFileKind(FileKind fileKind) {
        this.fileKind = fileKind;
    }

    public String getFileNameRegExpMatcher() {
        return fileNameRegExpMatcher;
    }

    public void setFileNameRegExpMatcher(String fileNameRegExpMatcher) {
        this.fileNameRegExpMatcher = fileNameRegExpMatcher;
    }

    public FileTimeManagement getFileTimeManagement() {
        return fileTimeManagement;
    }

    public void setFileTimeManagement(FileTimeManagement fileTimeManagement) {
        this.fileTimeManagement = fileTimeManagement;
    }

    public GftKanaal getGftKanaal() {
        return gftKanaal;
    }

    public void setGftKanaal(GftKanaal gftKanaal) {
        this.gftKanaal = gftKanaal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}