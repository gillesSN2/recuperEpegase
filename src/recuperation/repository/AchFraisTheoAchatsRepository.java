package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.AchFraisTheoAchats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AchFraisTheoAchatsRepository extends JpaRepository<AchFraisTheoAchats, Long>, JpaSpecificationExecutor<AchFraisTheoAchats> {

}