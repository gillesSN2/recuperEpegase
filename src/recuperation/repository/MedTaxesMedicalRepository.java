package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.MedTaxesMedical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MedTaxesMedicalRepository extends JpaRepository<MedTaxesMedical, Long>, JpaSpecificationExecutor<MedTaxesMedical> {

}