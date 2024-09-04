package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.AchCommandeEntete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AchCommandeEnteteRepository extends JpaRepository<AchCommandeEntete, Long>, JpaSpecificationExecutor<AchCommandeEntete> {

}