package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.PaySalariesMissions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PaySalariesMissionsRepository extends JpaRepository<PaySalariesMissions, Long>, JpaSpecificationExecutor<PaySalariesMissions> {

}