package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.AchSuiviCommandeAchats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AchSuiviCommandeAchatsRepository extends JpaRepository<AchSuiviCommandeAchats, Long>, JpaSpecificationExecutor<AchSuiviCommandeAchats> {

}