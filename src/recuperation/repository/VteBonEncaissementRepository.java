package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.VteBonEncaissement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VteBonEncaissementRepository extends JpaRepository<VteBonEncaissement, Long>, JpaSpecificationExecutor<VteBonEncaissement> {

}