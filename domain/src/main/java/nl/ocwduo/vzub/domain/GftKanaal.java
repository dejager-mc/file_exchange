package nl.ocwduo.vzub.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Machiel de Jager on 20-2-2016.
 */
public class GftKanaal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String kanaalNaam;
}
