package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.AchValorisationEntete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AchValorisationEnteteRepository extends JpaRepository<AchValorisationEntete, Long>, JpaSpecificationExecutor<AchValorisationEntete> {

}