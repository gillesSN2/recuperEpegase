package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.VteAvoirLigne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VteAvoirLigneRepository extends JpaRepository<VteAvoirLigne, Long>, JpaSpecificationExecutor<VteAvoirLigne> {

}