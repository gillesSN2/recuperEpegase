package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.PrcFamillesParc1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PrcFamillesParc1Repository extends JpaRepository<PrcFamillesParc1, Long>, JpaSpecificationExecutor<PrcFamillesParc1> {

}