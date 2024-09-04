package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmPlanAnalytiqueRepartition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmPlanAnalytiqueRepartitionRepository extends JpaRepository<CmmPlanAnalytiqueRepartition, Long>, JpaSpecificationExecutor<CmmPlanAnalytiqueRepartition> {

}