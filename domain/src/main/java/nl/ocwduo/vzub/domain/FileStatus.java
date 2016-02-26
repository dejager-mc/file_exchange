package nl.ocwduo.vzub.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Machiel de Jager on 26-2-2016.
 */
@Entity
public class FileStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String status;
    private Long moment;
}
