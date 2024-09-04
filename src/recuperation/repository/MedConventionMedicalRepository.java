package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.MedConventionMedical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MedConventionMedicalRepository extends JpaRepository<MedConventionMedical, Long>, JpaSpecificationExecutor<MedConventionMedical> {

}