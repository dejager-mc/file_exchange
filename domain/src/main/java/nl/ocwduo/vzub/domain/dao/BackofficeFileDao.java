package nl.ocwduo.vzub.domain.dao;

import nl.ocwduo.vzub.domain.model.file.BackofficeFile;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Machiel de Jager on 20-2-2016.
 */
public interface BackofficeFileDao extends JpaRepository<BackofficeFile, Long> {

}
