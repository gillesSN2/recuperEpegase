package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmProduitsGrp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmProduitsGrpRepository extends JpaRepository<CmmProduitsGrp, Long>, JpaSpecificationExecutor<CmmProduitsGrp> {

}