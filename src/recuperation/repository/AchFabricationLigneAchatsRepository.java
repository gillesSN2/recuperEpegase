package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.AchFabricationLigneAchats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AchFabricationLigneAchatsRepository extends JpaRepository<AchFabricationLigneAchats, Long>, JpaSpecificationExecutor<AchFabricationLigneAchats> {

}