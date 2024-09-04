package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CptBudget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CptBudgetRepository extends JpaRepository<CptBudget, Long>, JpaSpecificationExecutor<CptBudget> {

}