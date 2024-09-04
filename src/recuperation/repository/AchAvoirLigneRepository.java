package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.AchAvoirLigne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AchAvoirLigneRepository extends JpaRepository<AchAvoirLigne, Long>, JpaSpecificationExecutor<AchAvoirLigne> {

}