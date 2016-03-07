package nl.ocwduo.vzub.domain.dao.file;

import nl.ocwduo.vzub.domain.model.file.File;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Machiel de Jager on 20-2-2016.
 */
public interface BackofficeFileDao extends JpaRepository<File, Long> {
    // find files for FileTypeConfiguration
}
