package nl.ocwduo.vzub.domain.model;

import javax.persistence.*;

/**
 * Created by Machiel de Jager on 21-2-2016.
 */
@Entity
@Table(name = "EMAILNOTIFICATION")
public class EmailNotification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 255)
    private String subject;
    @Column(length = 10240)
    private String content;
}
