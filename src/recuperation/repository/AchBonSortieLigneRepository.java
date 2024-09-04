package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.AchBonSortieLigne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AchBonSortieLigneRepository extends JpaRepository<AchBonSortieLigne, Long>, JpaSpecificationExecutor<AchBonSortieLigne> {

}