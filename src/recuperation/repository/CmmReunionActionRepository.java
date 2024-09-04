package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmReunionAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmReunionActionRepository extends JpaRepository<CmmReunionAction, Long>, JpaSpecificationExecutor<CmmReunionAction> {

}