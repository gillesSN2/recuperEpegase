package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.VteSimulationEntete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VteSimulationEnteteRepository extends JpaRepository<VteSimulationEntete, Long>, JpaSpecificationExecutor<VteSimulationEntete> {

}