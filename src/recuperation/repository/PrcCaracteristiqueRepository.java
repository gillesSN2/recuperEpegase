package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.PrcCaracteristique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PrcCaracteristiqueRepository extends JpaRepository<PrcCaracteristique, Long>, JpaSpecificationExecutor<PrcCaracteristique> {

}