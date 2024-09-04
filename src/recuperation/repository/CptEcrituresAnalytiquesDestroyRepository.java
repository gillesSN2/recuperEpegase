package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CptEcrituresAnalytiquesDestroy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CptEcrituresAnalytiquesDestroyRepository extends JpaRepository<CptEcrituresAnalytiquesDestroy, Long>, JpaSpecificationExecutor<CptEcrituresAnalytiquesDestroy> {

}