package nl.ocwduo.vzub.domain;

import javax.persistence.*;

/**
 * Created by Machiel de Jager on 21-2-2016.
 */
@Entity
@Table(name = "EMAIL_N")
public class EmailNotification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 255)
    private String subject;
    @Column(length = 10240)
    private String text;
}
