package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CptBudgetTresorerieLigne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CptBudgetTresorerieLigneRepository extends JpaRepository<CptBudgetTresorerieLigne, Long>, JpaSpecificationExecutor<CptBudgetTresorerieLigne> {

}