package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.AchCessionLigne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AchCessionLigneRepository extends JpaRepository<AchCessionLigne, Long>, JpaSpecificationExecutor<AchCessionLigne> {

}