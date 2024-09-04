package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CaiCaissesCommerciales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CaiCaissesCommercialesRepository extends JpaRepository<CaiCaissesCommerciales, Long>, JpaSpecificationExecutor<CaiCaissesCommerciales> {

}