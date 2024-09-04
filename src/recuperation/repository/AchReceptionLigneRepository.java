package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.AchReceptionLigne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AchReceptionLigneRepository extends JpaRepository<AchReceptionLigne, Long>, JpaSpecificationExecutor<AchReceptionLigne> {

}