package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.AchCessionEntete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AchCessionEnteteRepository extends JpaRepository<AchCessionEntete, Long>, JpaSpecificationExecutor<AchCessionEntete> {

}