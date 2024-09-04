package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.MedHospitalisationMedi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MedHospitalisationMediRepository extends JpaRepository<MedHospitalisationMedi, Long>, JpaSpecificationExecutor<MedHospitalisationMedi> {

}