package nl.ocwduo.vzub.domain.model;

import javax.persistence.*;

/**
 * Created by Machiel de Jager on 26-2-2016.
 */
@Entity
@Table
public class FileStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 30)
    private String status;
    @Column(length = 20)
    private Long moment;
}
