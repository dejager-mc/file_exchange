package nl.ocwduo.vzub.domain.model.fileType.details;

import javax.persistence.*;

/**
 * Created by in434jag on 21-3-2016.
 */
@Entity
@Table(name = "Organisatie")
public class Organisatie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORGANISATIE_ID")
    private Long id;

    @Column(name = "ORGANISATIE_NUMMER", nullable = false)
    private int organisatieId;

    @Column(name = "ORGANISATIE_WAARDE")
    private String organisatieWaarde;

    @Column(name = "ORGANISATIE_NAAM")
    private String organisatieNaam;


    public Long getId() {
        return id;
    }

    public int getOrganisatieId() {
        return organisatieId;
    }

    public void setOrganisatieId(int organisatieId) {
        this.organisatieId = organisatieId;
    }

    public String getOrganisatieWaarde() {
        return organisatieWaarde;
    }

    public void setOrganisatieWaarde(String organisatieWaarde) {
        this.organisatieWaarde = organisatieWaarde;
    }

    public String getOrganisatieNaam() {
        return organisatieNaam;
    }

    public void setOrganisatieNaam(String organisatieNaam) {
        this.organisatieNaam = organisatieNaam;
    }
}
