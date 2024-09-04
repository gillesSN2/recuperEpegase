package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmProduitsHistoRef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmProduitsHistoRefRepository extends JpaRepository<CmmProduitsHistoRef, Long>, JpaSpecificationExecutor<CmmProduitsHistoRef> {

}