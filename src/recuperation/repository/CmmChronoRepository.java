package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmChrono;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmChronoRepository extends JpaRepository<CmmChrono, Long>, JpaSpecificationExecutor<CmmChrono> {

}