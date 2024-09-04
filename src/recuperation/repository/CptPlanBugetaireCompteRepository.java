package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CptPlanBugetaireCompte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CptPlanBugetaireCompteRepository extends JpaRepository<CptPlanBugetaireCompte, Long>, JpaSpecificationExecutor<CptPlanBugetaireCompte> {

}