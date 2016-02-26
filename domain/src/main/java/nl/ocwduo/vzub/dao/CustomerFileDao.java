package nl.ocwduo.vzub.dao;

import nl.ocwduo.vzub.domain.CustomerFile;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Max Hunt on 26-2-2016.
 */
public interface CustomerFileDao extends JpaRepository<CustomerFile, Long> {

}
