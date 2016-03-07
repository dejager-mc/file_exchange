package nl.ocwduo.vzub.domain.model.fileType.details;

import nl.ocwduo.vzub.domain.model.fileType.FileTypeConfiguration;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Machiel de Jager on 21-2-2016.
 */
@Entity
@Table(name = "Email_Notification")
public class EmailNotification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @NotNull
    private FileTypeConfiguration fileTypeConfiguration;

    @Email
    @Column(length = 512)
    private String fromEmailAddress;
    @Column(length = 1024)
    @NotNull
    private String subject;
    @Column(length = 10240)
    @NotNull
    private String content;

    public FileTypeConfiguration getFileTypeConfiguration() {
        return fileTypeConfiguration;
    }

    public void setFileTypeConfiguration(FileTypeConfiguration fileTypeConfiguration) {
        this.fileTypeConfiguration = fileTypeConfiguration;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFromEmailAddress() {
        return fromEmailAddress;
    }

    public void setFromEmailAddress(String fromEmailAddress) {
        this.fromEmailAddress = fromEmailAddress;
    }

    public long getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
