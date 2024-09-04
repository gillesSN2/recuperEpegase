package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmTiers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmTiersRepository extends JpaRepository<CmmTiers, Long>, JpaSpecificationExecutor<CmmTiers> {

}