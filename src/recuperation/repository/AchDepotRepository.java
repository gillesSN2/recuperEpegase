package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.AchDepot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AchDepotRepository extends JpaRepository<AchDepot, Long>, JpaSpecificationExecutor<AchDepot> {

}