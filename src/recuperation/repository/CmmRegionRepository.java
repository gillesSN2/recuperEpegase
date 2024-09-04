package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmRegion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmRegionRepository extends JpaRepository<CmmRegion, Long>, JpaSpecificationExecutor<CmmRegion> {

}