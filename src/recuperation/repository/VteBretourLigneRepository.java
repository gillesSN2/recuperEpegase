package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.VteBretourLigne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VteBretourLigneRepository extends JpaRepository<VteBretourLigne, Long>, JpaSpecificationExecutor<VteBretourLigne> {

}