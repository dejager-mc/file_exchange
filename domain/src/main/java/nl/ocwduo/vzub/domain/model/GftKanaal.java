package nl.ocwduo.vzub.domain.model;

import javax.persistence.*;

/**
 * Created by Machiel de Jager on 20-2-2016.
 */
@Entity
@Table
public class GftKanaal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 50)
    private String kanaalNaam;
}
