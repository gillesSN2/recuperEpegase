package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.VteBesoinLigne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VteBesoinLigneRepository extends JpaRepository<VteBesoinLigne, Long>, JpaSpecificationExecutor<VteBesoinLigne> {

}