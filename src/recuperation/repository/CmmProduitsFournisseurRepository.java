package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmProduitsFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmProduitsFournisseurRepository extends JpaRepository<CmmProduitsFournisseur, Long>, JpaSpecificationExecutor<CmmProduitsFournisseur> {

}