package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.AchInventaireEntete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AchInventaireEnteteRepository extends JpaRepository<AchInventaireEntete, Long>, JpaSpecificationExecutor<AchInventaireEntete> {

}