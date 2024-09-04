package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.AchBonEntreeLigne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AchBonEntreeLigneRepository extends JpaRepository<AchBonEntreeLigne, Long>, JpaSpecificationExecutor<AchBonEntreeLigne> {

}