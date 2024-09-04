package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmSecteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmSecteurRepository extends JpaRepository<CmmSecteur, Long>, JpaSpecificationExecutor<CmmSecteur> {

}