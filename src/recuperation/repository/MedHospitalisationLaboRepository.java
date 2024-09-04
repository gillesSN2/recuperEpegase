package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.MedHospitalisationLabo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MedHospitalisationLaboRepository extends JpaRepository<MedHospitalisationLabo, Long>, JpaSpecificationExecutor<MedHospitalisationLabo> {

}