package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.MedFamillesProduitsMedical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MedFamillesProduitsMedicalRepository extends JpaRepository<MedFamillesProduitsMedical, Long>, JpaSpecificationExecutor<MedFamillesProduitsMedical> {

}