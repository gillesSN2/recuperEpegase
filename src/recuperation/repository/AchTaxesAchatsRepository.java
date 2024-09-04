package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.AchTaxesAchats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AchTaxesAchatsRepository extends JpaRepository<AchTaxesAchats, Long>, JpaSpecificationExecutor<AchTaxesAchats> {

}