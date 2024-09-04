package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmGroupeChrono;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmGroupeChronoRepository extends JpaRepository<CmmGroupeChrono, Long>, JpaSpecificationExecutor<CmmGroupeChrono> {

}