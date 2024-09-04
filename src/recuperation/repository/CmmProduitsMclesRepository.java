package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmProduitsMcles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmProduitsMclesRepository extends JpaRepository<CmmProduitsMcles, Long>, JpaSpecificationExecutor<CmmProduitsMcles> {

}