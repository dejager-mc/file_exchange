package nl.ocwduo.vzub.domain.model.fileType.genericDetails;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by in434jag on 3-3-2016.
 */
@Entity
@Table
public class FileTimeManagement {

    private int keepFileForDays;
    private int keepFileAfterDownloadingForDays;

}
