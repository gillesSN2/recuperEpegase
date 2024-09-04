package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.AchCommandeLigne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AchCommandeLigneRepository extends JpaRepository<AchCommandeLigne, Long>, JpaSpecificationExecutor<AchCommandeLigne> {

}