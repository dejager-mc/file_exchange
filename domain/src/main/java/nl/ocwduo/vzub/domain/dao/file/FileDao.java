package nl.ocwduo.vzub.domain.dao.file;

import nl.ocwduo.vzub.domain.model.file.File;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by in434jag on 7-3-2016.
 */
public interface FileDao extends JpaRepository<File, Long> {
}
