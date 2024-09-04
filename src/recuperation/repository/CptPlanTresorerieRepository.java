package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CptPlanTresorerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CptPlanTresorerieRepository extends JpaRepository<CptPlanTresorerie, Long>, JpaSpecificationExecutor<CptPlanTresorerie> {

}