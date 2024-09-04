package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.AchFactureLigne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AchFactureLigneRepository extends JpaRepository<AchFactureLigne, Long>, JpaSpecificationExecutor<AchFactureLigne> {

}