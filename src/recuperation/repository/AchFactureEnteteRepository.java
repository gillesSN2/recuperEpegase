package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.AchFactureEntete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AchFactureEnteteRepository extends JpaRepository<AchFactureEntete, Long>, JpaSpecificationExecutor<AchFactureEntete> {

}