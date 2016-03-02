package nl.ocwduo.vzub.domain.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by in434jag on 2-3-2016.
 */
@Entity
@Table(name = "Dienst")
public class Dienst {

    private String name;
    private String value;
}
