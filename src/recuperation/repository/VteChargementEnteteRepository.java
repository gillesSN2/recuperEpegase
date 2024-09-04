package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.VteChargementEntete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VteChargementEnteteRepository extends JpaRepository<VteChargementEntete, Long>, JpaSpecificationExecutor<VteChargementEntete> {

}