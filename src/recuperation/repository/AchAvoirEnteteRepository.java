package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.AchAvoirEntete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AchAvoirEnteteRepository extends JpaRepository<AchAvoirEntete, Long>, JpaSpecificationExecutor<AchAvoirEntete> {

}