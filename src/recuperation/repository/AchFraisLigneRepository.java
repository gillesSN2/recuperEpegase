package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.AchFraisLigne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AchFraisLigneRepository extends JpaRepository<AchFraisLigne, Long>, JpaSpecificationExecutor<AchFraisLigne> {

}