package nl.ocwduo.vzub.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Machiel de Jager on 20-2-2016.
 */

/*
    Een bestand dat van de klant komt
 */
@Entity
@Table(name = "Customer_File")
public class CustomerFile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @NotNull
    private GftKanaal gftKanaal;

    @OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private FileSpecs fileSpecs;

    //    private Dienst dienst;    // De dienst die gekoppeld is aan dit bestand
}
