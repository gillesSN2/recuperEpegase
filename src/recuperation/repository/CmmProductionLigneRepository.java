package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmProductionLigne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmProductionLigneRepository extends JpaRepository<CmmProductionLigne, Long>, JpaSpecificationExecutor<CmmProductionLigne> {

}