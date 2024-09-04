package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmProductionAtelier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmProductionAtelierRepository extends JpaRepository<CmmProductionAtelier, Long>, JpaSpecificationExecutor<CmmProductionAtelier> {

}