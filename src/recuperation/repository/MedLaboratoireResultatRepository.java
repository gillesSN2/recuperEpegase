package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.MedLaboratoireResultat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MedLaboratoireResultatRepository extends JpaRepository<MedLaboratoireResultat, Long>, JpaSpecificationExecutor<MedLaboratoireResultat> {

}