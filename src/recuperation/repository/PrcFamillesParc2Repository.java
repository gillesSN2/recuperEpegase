package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.PrcFamillesParc2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PrcFamillesParc2Repository extends JpaRepository<PrcFamillesParc2, Long>, JpaSpecificationExecutor<PrcFamillesParc2> {

}