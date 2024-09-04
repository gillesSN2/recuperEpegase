package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.MedCcam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MedCcamRepository extends JpaRepository<MedCcam, Long>, JpaSpecificationExecutor<MedCcam> {

}