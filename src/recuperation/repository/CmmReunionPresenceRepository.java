package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmReunionPresence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmReunionPresenceRepository extends JpaRepository<CmmReunionPresence, Long>, JpaSpecificationExecutor<CmmReunionPresence> {

}