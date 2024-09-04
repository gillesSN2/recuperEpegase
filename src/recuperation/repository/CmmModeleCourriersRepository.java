package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmModeleCourriers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmModeleCourriersRepository extends JpaRepository<CmmModeleCourriers, Long>, JpaSpecificationExecutor<CmmModeleCourriers> {

}