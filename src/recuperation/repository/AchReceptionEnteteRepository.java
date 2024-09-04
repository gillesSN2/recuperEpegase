package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.AchReceptionEntete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AchReceptionEnteteRepository extends JpaRepository<AchReceptionEntete, Long>, JpaSpecificationExecutor<AchReceptionEntete> {

}