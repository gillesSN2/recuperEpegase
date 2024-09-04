package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.PrcParcCaracteristique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PrcParcCaracteristiqueRepository extends JpaRepository<PrcParcCaracteristique, Long>, JpaSpecificationExecutor<PrcParcCaracteristique> {

}