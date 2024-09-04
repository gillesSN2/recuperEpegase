package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.Departements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DepartementsRepository extends JpaRepository<Departements, Long>, JpaSpecificationExecutor<Departements> {

}