package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmProduitsActe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmProduitsActeRepository extends JpaRepository<CmmProduitsActe, Long>, JpaSpecificationExecutor<CmmProduitsActe> {

}