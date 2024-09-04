package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.MedPatientPec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MedPatientPecRepository extends JpaRepository<MedPatientPec, Long>, JpaSpecificationExecutor<MedPatientPec> {

}