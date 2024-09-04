package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.McfDossier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface McfDossierRepository extends JpaRepository<McfDossier, Long>, JpaSpecificationExecutor<McfDossier> {

}