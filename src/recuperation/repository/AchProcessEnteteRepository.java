package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.AchProcessEntete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AchProcessEnteteRepository extends JpaRepository<AchProcessEntete, Long>, JpaSpecificationExecutor<AchProcessEntete> {

}