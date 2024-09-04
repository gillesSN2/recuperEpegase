package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.VteDevisLigne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VteDevisLigneRepository extends JpaRepository<VteDevisLigne, Long>, JpaSpecificationExecutor<VteDevisLigne> {

}