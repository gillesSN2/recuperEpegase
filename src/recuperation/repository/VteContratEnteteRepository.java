package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.VteContratEntete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VteContratEnteteRepository extends JpaRepository<VteContratEntete, Long>, JpaSpecificationExecutor<VteContratEntete> {

}