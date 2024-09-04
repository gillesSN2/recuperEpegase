package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.MedPatients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MedPatientsRepository extends JpaRepository<MedPatients, Long>, JpaSpecificationExecutor<MedPatients> {

}