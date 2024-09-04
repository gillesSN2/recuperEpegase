package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmProduitsTarif;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmProduitsTarifRepository extends JpaRepository<CmmProduitsTarif, Long>, JpaSpecificationExecutor<CmmProduitsTarif> {

}