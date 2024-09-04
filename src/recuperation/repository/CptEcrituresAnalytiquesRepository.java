package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CptEcrituresAnalytiques;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CptEcrituresAnalytiquesRepository extends JpaRepository<CptEcrituresAnalytiques, Long>, JpaSpecificationExecutor<CptEcrituresAnalytiques> {

}