package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmResponsable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmResponsableRepository extends JpaRepository<CmmResponsable, Long>, JpaSpecificationExecutor<CmmResponsable> {

}