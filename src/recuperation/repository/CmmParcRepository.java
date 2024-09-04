package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmParc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmParcRepository extends JpaRepository<CmmParc, Long>, JpaSpecificationExecutor<CmmParc> {

}