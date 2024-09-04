package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.MedPatientAnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MedPatientAntRepository extends JpaRepository<MedPatientAnt, Long>, JpaSpecificationExecutor<MedPatientAnt> {

}