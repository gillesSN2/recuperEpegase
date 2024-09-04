package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.AchExercicesAchats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AchExercicesAchatsRepository extends JpaRepository<AchExercicesAchats, Long>, JpaSpecificationExecutor<AchExercicesAchats> {

}