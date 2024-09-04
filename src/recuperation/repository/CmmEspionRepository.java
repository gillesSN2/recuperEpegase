package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmEspion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmEspionRepository extends JpaRepository<CmmEspion, Long>, JpaSpecificationExecutor<CmmEspion> {

}