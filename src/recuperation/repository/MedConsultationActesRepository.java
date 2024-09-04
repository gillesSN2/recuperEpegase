package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.MedConsultationActes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MedConsultationActesRepository extends JpaRepository<MedConsultationActes, Long>, JpaSpecificationExecutor<MedConsultationActes> {

}