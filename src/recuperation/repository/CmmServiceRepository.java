package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmServiceRepository extends JpaRepository<CmmService, Long>, JpaSpecificationExecutor<CmmService> {

}