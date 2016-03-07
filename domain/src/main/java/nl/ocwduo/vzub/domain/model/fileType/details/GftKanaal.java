package nl.ocwduo.vzub.domain.model.fileType.details;

import nl.ocwduo.vzub.domain.model.fileType.FileTypeConfiguration;

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
    private Long id;

    @OneToOne
    @NotNull
    private FileTypeConfiguration fileTypeConfiguration;

    @Column(length = 50)
    @NotNull
    private String kanaalNaam;

    public FileTypeConfiguration getFileTypeConfiguration() {
        return fileTypeConfiguration;
    }

    public void setFileTypeConfiguration(FileTypeConfiguration fileTypeConfiguration) {
        this.fileTypeConfiguration = fileTypeConfiguration;
    }

    public Long getId() {
        return id;
    }

    public String getKanaalNaam() {
        return kanaalNaam;
    }

    public void setKanaalNaam(String kanaalNaam) {
        this.kanaalNaam = kanaalNaam;
    }
}
