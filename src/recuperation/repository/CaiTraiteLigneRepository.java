package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CaiTraiteLigne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CaiTraiteLigneRepository extends JpaRepository<CaiTraiteLigne, Long>, JpaSpecificationExecutor<CaiTraiteLigne> {

}