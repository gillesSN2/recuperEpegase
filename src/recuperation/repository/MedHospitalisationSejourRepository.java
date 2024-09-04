package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.MedHospitalisationSejour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MedHospitalisationSejourRepository extends JpaRepository<MedHospitalisationSejour, Long>, JpaSpecificationExecutor<MedHospitalisationSejour> {

}