package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.AchReceptionSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AchReceptionSerieRepository extends JpaRepository<AchReceptionSerie, Long>, JpaSpecificationExecutor<AchReceptionSerie> {

}