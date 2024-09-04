package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.MedHospitalisationActes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MedHospitalisationActesRepository extends JpaRepository<MedHospitalisationActes, Long>, JpaSpecificationExecutor<MedHospitalisationActes> {

}