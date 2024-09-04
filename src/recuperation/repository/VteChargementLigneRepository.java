package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.VteChargementLigne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VteChargementLigneRepository extends JpaRepository<VteChargementLigne, Long>, JpaSpecificationExecutor<VteChargementLigne> {

}