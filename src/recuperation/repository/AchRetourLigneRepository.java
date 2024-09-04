package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.AchRetourLigne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AchRetourLigneRepository extends JpaRepository<AchRetourLigne, Long>, JpaSpecificationExecutor<AchRetourLigne> {

}