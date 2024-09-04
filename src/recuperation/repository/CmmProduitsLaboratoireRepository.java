package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmProduitsLaboratoire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmProduitsLaboratoireRepository extends JpaRepository<CmmProduitsLaboratoire, Long>, JpaSpecificationExecutor<CmmProduitsLaboratoire> {

}