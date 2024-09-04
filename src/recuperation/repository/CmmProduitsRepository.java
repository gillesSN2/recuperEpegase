package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmProduits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmProduitsRepository extends JpaRepository<CmmProduits, Long>, JpaSpecificationExecutor<CmmProduits> {

}