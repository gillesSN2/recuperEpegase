package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.AchSommierEntete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AchSommierEnteteRepository extends JpaRepository<AchSommierEntete, Long>, JpaSpecificationExecutor<AchSommierEntete> {

}