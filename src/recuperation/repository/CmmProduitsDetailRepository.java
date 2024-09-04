package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmProduitsDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmProduitsDetailRepository extends JpaRepository<CmmProduitsDetail, Long>, JpaSpecificationExecutor<CmmProduitsDetail> {

}