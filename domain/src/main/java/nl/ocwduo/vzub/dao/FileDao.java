package nl.ocwduo.vzub.dao;

import nl.ocwduo.vzub.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Max Hunt on 20-2-2016.
 */
public interface FileDao extends JpaRepository<File, Long> {
}
