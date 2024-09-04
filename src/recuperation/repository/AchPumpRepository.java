package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.AchPump;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AchPumpRepository extends JpaRepository<AchPump, Long>, JpaSpecificationExecutor<AchPump> {

}