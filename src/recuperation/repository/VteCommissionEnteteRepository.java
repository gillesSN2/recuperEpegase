package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.VteCommissionEntete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VteCommissionEnteteRepository extends JpaRepository<VteCommissionEntete, Long>, JpaSpecificationExecutor<VteCommissionEntete> {

}