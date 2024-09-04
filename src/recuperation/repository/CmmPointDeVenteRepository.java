package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmPointDeVente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmPointDeVenteRepository extends JpaRepository<CmmPointDeVente, Long>, JpaSpecificationExecutor<CmmPointDeVente> {

}