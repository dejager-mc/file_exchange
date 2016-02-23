package nl.ocwduo.vzub.dao;

import nl.ocwduo.vzub.domain.FileSpecs;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Machiel de Jager on 20-2-2016.
 */
public interface BackofficeFileDao extends JpaRepository<FileSpecs, Long> {

    FileSpecs findById(long id);
}
