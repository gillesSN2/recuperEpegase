package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmCouleur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmCouleurRepository extends JpaRepository<CmmCouleur, Long>, JpaSpecificationExecutor<CmmCouleur> {

}