package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.VteFormulesVentes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VteFormulesVentesRepository extends JpaRepository<VteFormulesVentes, Long>, JpaSpecificationExecutor<VteFormulesVentes> {

}