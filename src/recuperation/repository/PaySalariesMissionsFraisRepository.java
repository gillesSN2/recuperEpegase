package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.PaySalariesMissionsFrais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PaySalariesMissionsFraisRepository extends JpaRepository<PaySalariesMissionsFrais, Long>, JpaSpecificationExecutor<PaySalariesMissionsFrais> {

}