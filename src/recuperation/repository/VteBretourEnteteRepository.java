package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.VteBretourEntete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VteBretourEnteteRepository extends JpaRepository<VteBretourEntete, Long>, JpaSpecificationExecutor<VteBretourEntete> {

}