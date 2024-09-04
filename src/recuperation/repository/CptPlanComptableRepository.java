package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CptPlanComptable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CptPlanComptableRepository extends JpaRepository<CptPlanComptable, Long>, JpaSpecificationExecutor<CptPlanComptable> {

}