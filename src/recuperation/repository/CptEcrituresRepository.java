package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CptEcritures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CptEcrituresRepository extends JpaRepository<CptEcritures, Long>, JpaSpecificationExecutor<CptEcritures> {

}