package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmMarques;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmMarquesRepository extends JpaRepository<CmmMarques, Long>, JpaSpecificationExecutor<CmmMarques> {

}