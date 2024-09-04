package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmUsersChrono;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmUsersChronoRepository extends JpaRepository<CmmUsersChrono, Long>, JpaSpecificationExecutor<CmmUsersChrono> {

}