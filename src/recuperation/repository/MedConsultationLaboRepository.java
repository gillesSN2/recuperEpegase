package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.MedConsultationLabo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MedConsultationLaboRepository extends JpaRepository<MedConsultationLabo, Long>, JpaSpecificationExecutor<MedConsultationLabo> {

}