package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.VteTaxesVentes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VteTaxesVentesRepository extends JpaRepository<VteTaxesVentes, Long>, JpaSpecificationExecutor<VteTaxesVentes> {

}