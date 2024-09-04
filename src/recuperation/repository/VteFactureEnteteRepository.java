package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.VteFactureEntete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VteFactureEnteteRepository extends JpaRepository<VteFactureEntete, Long>, JpaSpecificationExecutor<VteFactureEntete> {

}