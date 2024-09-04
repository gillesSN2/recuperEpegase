package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CptBudgetTresorerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CptBudgetTresorerieRepository extends JpaRepository<CptBudgetTresorerie, Long>, JpaSpecificationExecutor<CptBudgetTresorerie> {

}