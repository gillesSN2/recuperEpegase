package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.MedProduitsMedicamment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MedProduitsMedicammentRepository extends JpaRepository<MedProduitsMedicamment, Long>, JpaSpecificationExecutor<MedProduitsMedicamment> {

}