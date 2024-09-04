package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.AchDemandeLigne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AchDemandeLigneRepository extends JpaRepository<AchDemandeLigne, Long>, JpaSpecificationExecutor<AchDemandeLigne> {

}