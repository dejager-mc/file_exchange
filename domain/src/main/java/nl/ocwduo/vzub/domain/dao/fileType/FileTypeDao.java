package nl.ocwduo.vzub.domain.dao.fileType;

import nl.ocwduo.vzub.domain.model.fileType.FileType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Machiel de Jager on 26-2-2016.
 */
public interface FileTypeDao extends JpaRepository<FileType, Long> {
    FileType findByName(String name);
}
