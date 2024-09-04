package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.PrcParcConsommation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PrcParcConsommationRepository extends JpaRepository<PrcParcConsommation, Long>, JpaSpecificationExecutor<PrcParcConsommation> {

}