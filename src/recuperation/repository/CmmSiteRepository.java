package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmSite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmSiteRepository extends JpaRepository<CmmSite, Long>, JpaSpecificationExecutor<CmmSite> {

}