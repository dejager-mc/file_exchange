package nl.ocwduo.vzub.domain.model.fileType.genericDetails;

import nl.ocwduo.vzub.domain.model.theFile.FileSpecs;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Machiel de Jager on 26-2-2016.
 */
@Entity
@Table(name = "File_Status")
public class FileStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 30)
    @NotNull
    private String status;
    @Column(length = 20)
    @NotNull
    private Long moment;
    private java.time.LocalDateTime time;
    @ManyToOne
    private FileSpecs fileSpecs;
}