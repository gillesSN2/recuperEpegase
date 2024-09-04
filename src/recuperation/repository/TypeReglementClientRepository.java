package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.TypeReglementClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TypeReglementClientRepository extends JpaRepository<TypeReglementClient, String>, JpaSpecificationExecutor<TypeReglementClient> {

}