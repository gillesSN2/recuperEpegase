package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmActivites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmActivitesRepository extends JpaRepository<CmmActivites, Long>, JpaSpecificationExecutor<CmmActivites> {

}