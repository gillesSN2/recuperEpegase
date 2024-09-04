package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmProjet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmProjetRepository extends JpaRepository<CmmProjet, Long>, JpaSpecificationExecutor<CmmProjet> {

}