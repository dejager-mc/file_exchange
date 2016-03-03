package nl.ocwduo.vzub.domain.model.fileType.genericDetails;

import javax.persistence.*;

/**
 * Created by in434jag on 2-3-2016.
 */
@Entity
@Table
public class Dienst {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String value;
}
