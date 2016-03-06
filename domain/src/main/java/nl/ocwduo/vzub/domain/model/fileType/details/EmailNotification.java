package nl.ocwduo.vzub.domain.model.fileType.details;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Machiel de Jager on 21-2-2016.
 */
@Entity
@Table(name = "Email_Notification")
public class EmailNotification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    // annotatie?
    private String fromEmailAddress;

    @Column(length = 255)
    @NotNull
    private String subject;
    @Column(length = 10240)
    @NotNull
    private String content;
}
