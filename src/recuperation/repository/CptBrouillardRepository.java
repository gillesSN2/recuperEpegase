package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CptBrouillard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CptBrouillardRepository extends JpaRepository<CptBrouillard, Long>, JpaSpecificationExecutor<CptBrouillard> {

}