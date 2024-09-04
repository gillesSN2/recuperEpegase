package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmProduitsReponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmProduitsReponseRepository extends JpaRepository<CmmProduitsReponse, Long>, JpaSpecificationExecutor<CmmProduitsReponse> {

}