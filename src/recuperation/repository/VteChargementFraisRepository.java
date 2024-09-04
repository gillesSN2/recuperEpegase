package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.VteChargementFrais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VteChargementFraisRepository extends JpaRepository<VteChargementFrais, Long>, JpaSpecificationExecutor<VteChargementFrais> {

}