package nl.ocwduo.vzub.domain.model.fileConfig.details;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Machiel de Jager on 20-2-2016.
 */
@Entity
@Table(name = "GFT_Kanaal")
public class GftKanaal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 50)
    @NotNull
    private String kanaalNaam;
}
