package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CptEcrituresAnterieur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CptEcrituresAnterieurRepository extends JpaRepository<CptEcrituresAnterieur, Long>, JpaSpecificationExecutor<CptEcrituresAnterieur> {

}