package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.VteDevisEntete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VteDevisEnteteRepository extends JpaRepository<VteDevisEntete, Long>, JpaSpecificationExecutor<VteDevisEntete> {

}