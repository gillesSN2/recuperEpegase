package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.FamilleClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FamilleClientRepository extends JpaRepository<FamilleClient, Long>, JpaSpecificationExecutor<FamilleClient> {

}