package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.PrcParcAffectation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PrcParcAffectationRepository extends JpaRepository<PrcParcAffectation, Long>, JpaSpecificationExecutor<PrcParcAffectation> {

}