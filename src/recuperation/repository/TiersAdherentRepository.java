package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.TiersAdherent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TiersAdherentRepository extends JpaRepository<TiersAdherent, Long>, JpaSpecificationExecutor<TiersAdherent> {

}