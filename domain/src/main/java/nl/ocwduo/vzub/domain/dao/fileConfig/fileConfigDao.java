package nl.ocwduo.vzub.domain.dao.fileConfig;

import nl.ocwduo.vzub.domain.model.fileType.FileTypeConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Machiel de Jager on 26-2-2016.
 */
public interface fileConfigDao extends JpaRepository<FileTypeConfiguration, String> {

}
