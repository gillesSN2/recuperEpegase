package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmProduitsFrais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmProduitsFraisRepository extends JpaRepository<CmmProduitsFrais, Long>, JpaSpecificationExecutor<CmmProduitsFrais> {

}