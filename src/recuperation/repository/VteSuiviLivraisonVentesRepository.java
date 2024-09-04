package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.VteSuiviLivraisonVentes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VteSuiviLivraisonVentesRepository extends JpaRepository<VteSuiviLivraisonVentes, Long>, JpaSpecificationExecutor<VteSuiviLivraisonVentes> {

}