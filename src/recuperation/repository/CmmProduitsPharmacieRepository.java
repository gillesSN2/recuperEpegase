package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmProduitsPharmacie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmProduitsPharmacieRepository extends JpaRepository<CmmProduitsPharmacie, Long>, JpaSpecificationExecutor<CmmProduitsPharmacie> {

}