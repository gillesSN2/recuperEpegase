package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.MedPatientProt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MedPatientProtRepository extends JpaRepository<MedPatientProt, Long>, JpaSpecificationExecutor<MedPatientProt> {

}