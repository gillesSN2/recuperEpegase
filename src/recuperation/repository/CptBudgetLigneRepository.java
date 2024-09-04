package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CptBudgetLigne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CptBudgetLigneRepository extends JpaRepository<CptBudgetLigne, Long>, JpaSpecificationExecutor<CptBudgetLigne> {

}