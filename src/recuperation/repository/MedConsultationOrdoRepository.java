package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.MedConsultationOrdo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MedConsultationOrdoRepository extends JpaRepository<MedConsultationOrdo, Long>, JpaSpecificationExecutor<MedConsultationOrdo> {

}