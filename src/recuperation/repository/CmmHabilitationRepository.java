package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmHabilitation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmHabilitationRepository extends JpaRepository<CmmHabilitation, Long>, JpaSpecificationExecutor<CmmHabilitation> {

}