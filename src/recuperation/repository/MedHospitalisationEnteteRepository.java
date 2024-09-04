package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.MedHospitalisationEntete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MedHospitalisationEnteteRepository extends JpaRepository<MedHospitalisationEntete, Long>, JpaSpecificationExecutor<MedHospitalisationEntete> {

}