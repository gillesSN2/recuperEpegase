package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CptPlanBudgetaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CptPlanBudgetaireRepository extends JpaRepository<CptPlanBudgetaire, Long>, JpaSpecificationExecutor<CptPlanBudgetaire> {

}