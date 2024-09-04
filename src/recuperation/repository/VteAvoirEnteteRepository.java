package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.VteAvoirEntete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VteAvoirEnteteRepository extends JpaRepository<VteAvoirEntete, Long>, JpaSpecificationExecutor<VteAvoirEntete> {

}