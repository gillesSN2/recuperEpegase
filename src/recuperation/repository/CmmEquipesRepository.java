package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmEquipes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmEquipesRepository extends JpaRepository<CmmEquipes, Long>, JpaSpecificationExecutor<CmmEquipes> {

}