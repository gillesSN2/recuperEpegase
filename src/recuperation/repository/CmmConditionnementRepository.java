package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmConditionnement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmConditionnementRepository extends JpaRepository<CmmConditionnement, Long>, JpaSpecificationExecutor<CmmConditionnement> {

}