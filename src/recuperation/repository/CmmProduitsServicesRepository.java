package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmProduitsServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmProduitsServicesRepository extends JpaRepository<CmmProduitsServices, Long>, JpaSpecificationExecutor<CmmProduitsServices> {

}