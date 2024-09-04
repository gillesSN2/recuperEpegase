package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.AchBonDecaissement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AchBonDecaissementRepository extends JpaRepository<AchBonDecaissement, Long>, JpaSpecificationExecutor<AchBonDecaissement> {

}