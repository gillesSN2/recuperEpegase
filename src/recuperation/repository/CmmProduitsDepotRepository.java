package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmProduitsDepot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmProduitsDepotRepository extends JpaRepository<CmmProduitsDepot, Long>, JpaSpecificationExecutor<CmmProduitsDepot> {

}