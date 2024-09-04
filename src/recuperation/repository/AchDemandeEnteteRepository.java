package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.AchDemandeEntete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AchDemandeEnteteRepository extends JpaRepository<AchDemandeEntete, Long>, JpaSpecificationExecutor<AchDemandeEntete> {

}