package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CaiCaissesJour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CaiCaissesJourRepository extends JpaRepository<CaiCaissesJour, Long>, JpaSpecificationExecutor<CaiCaissesJour> {

}