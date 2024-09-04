package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmProjetPoste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmProjetPosteRepository extends JpaRepository<CmmProjetPoste, Long>, JpaSpecificationExecutor<CmmProjetPoste> {

}