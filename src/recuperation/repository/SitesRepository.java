package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.Sites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SitesRepository extends JpaRepository<Sites, Long>, JpaSpecificationExecutor<Sites> {

}