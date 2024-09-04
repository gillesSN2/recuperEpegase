package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.PayMissions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PayMissionsRepository extends JpaRepository<PayMissions, Long>, JpaSpecificationExecutor<PayMissions> {

}