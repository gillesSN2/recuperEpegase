package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CaiCaissesOperations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CaiCaissesOperationsRepository extends JpaRepository<CaiCaissesOperations, Long>, JpaSpecificationExecutor<CaiCaissesOperations> {

}