package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.VteBcommandeEntete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VteBcommandeEnteteRepository extends JpaRepository<VteBcommandeEntete, Long>, JpaSpecificationExecutor<VteBcommandeEntete> {

}