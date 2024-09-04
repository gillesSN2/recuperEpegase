package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.FamillesClients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FamillesClientsRepository extends JpaRepository<FamillesClients, String>, JpaSpecificationExecutor<FamillesClients> {

}