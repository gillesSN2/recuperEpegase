package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.MedLaboratoireEntete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MedLaboratoireEnteteRepository extends JpaRepository<MedLaboratoireEntete, Long>, JpaSpecificationExecutor<MedLaboratoireEntete> {

}