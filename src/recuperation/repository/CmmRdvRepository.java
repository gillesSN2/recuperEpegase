package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmRdv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmRdvRepository extends JpaRepository<CmmRdv, Long>, JpaSpecificationExecutor<CmmRdv> {

}