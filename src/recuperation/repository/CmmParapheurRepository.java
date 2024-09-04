package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmParapheur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmParapheurRepository extends JpaRepository<CmmParapheur, Long>, JpaSpecificationExecutor<CmmParapheur> {

}