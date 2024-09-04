package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.VteFactureLigne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VteFactureLigneRepository extends JpaRepository<VteFactureLigne, Long>, JpaSpecificationExecutor<VteFactureLigne> {

}