package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmTiersTechnique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmTiersTechniqueRepository extends JpaRepository<CmmTiersTechnique, Long>, JpaSpecificationExecutor<CmmTiersTechnique> {

}