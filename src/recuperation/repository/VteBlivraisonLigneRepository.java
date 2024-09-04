package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.VteBlivraisonLigne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VteBlivraisonLigneRepository extends JpaRepository<VteBlivraisonLigne, Long>, JpaSpecificationExecutor<VteBlivraisonLigne> {

}