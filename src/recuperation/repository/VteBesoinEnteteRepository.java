package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.VteBesoinEntete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VteBesoinEnteteRepository extends JpaRepository<VteBesoinEntete, Long>, JpaSpecificationExecutor<VteBesoinEntete> {

}