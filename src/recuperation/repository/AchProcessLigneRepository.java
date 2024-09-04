package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.AchProcessLigne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AchProcessLigneRepository extends JpaRepository<AchProcessLigne, Long>, JpaSpecificationExecutor<AchProcessLigne> {

}