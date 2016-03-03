package nl.ocwduo.vzub.domain.dao;

import nl.ocwduo.vzub.domain.model.fileType.CustomerFile;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Machiel de Jager on 26-2-2016.
 */
public interface CustomerFileDao extends JpaRepository<CustomerFile, Long> {

}
