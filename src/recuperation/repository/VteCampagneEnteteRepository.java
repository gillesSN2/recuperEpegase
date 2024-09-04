package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.VteCampagneEntete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VteCampagneEnteteRepository extends JpaRepository<VteCampagneEntete, Long>, JpaSpecificationExecutor<VteCampagneEntete> {

}