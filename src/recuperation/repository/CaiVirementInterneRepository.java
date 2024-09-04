package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CaiVirementInterne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CaiVirementInterneRepository extends JpaRepository<CaiVirementInterne, Long>, JpaSpecificationExecutor<CaiVirementInterne> {

}