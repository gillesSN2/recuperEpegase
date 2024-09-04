package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.AchFabricationEnteteAchats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AchFabricationEnteteAchatsRepository extends JpaRepository<AchFabricationEnteteAchats, Long>, JpaSpecificationExecutor<AchFabricationEnteteAchats> {

}