package nl.ocwduo.vzub.domain.model.fileType;

import nl.ocwduo.vzub.domain.model.file.File;
import nl.ocwduo.vzub.domain.model.fileType.details.EmailNotification;
import nl.ocwduo.vzub.domain.model.fileType.details.FileTimeManagement;
import nl.ocwduo.vzub.domain.model.fileType.details.GftKanaal;
import nl.ocwduo.vzub.domain.model.fileType.enums.FileKind;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Machiel de Jager on 3-3-2016.
 */
@Entity
@Table(name = "File_Type_Configuration")
public class FileTypeConfiguration {

    @Id
    @NotNull
//    @UniqueConstraint()
    private String name;

    @Column(length = 500)
    @NotNull
    private String discription;
    @Column(length = 255)
    private String fileNameRegExpMatcher;

    // bevat alle wachttijden etc.
    @NotNull
    @OneToOne
    private FileTimeManagement fileTimeManagement;
    // in geval van customerfile
    @ManyToOne
    private GftKanaal gftKanaal;
    // in geval van backoffice file
    @OneToOne
    private EmailNotification emailNotification;
    // onderscheidend vermogen: backoffice of customer file
    @NotNull
    private FileKind fileKind;

    @OneToMany
    private List<File> file;

    public List<File> getFile() {
        return file;
    }

    public void setFile(List<File> file) {
        this.file = file;
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