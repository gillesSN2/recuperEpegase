package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.AchFamillesProduitsAchats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AchFamillesProduitsAchatsRepository extends JpaRepository<AchFamillesProduitsAchats, Long>, JpaSpecificationExecutor<AchFamillesProduitsAchats> {

}