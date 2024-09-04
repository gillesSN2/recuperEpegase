package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmProjetBailleur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmProjetBailleurRepository extends JpaRepository<CmmProjetBailleur, Long>, JpaSpecificationExecutor<CmmProjetBailleur> {

}