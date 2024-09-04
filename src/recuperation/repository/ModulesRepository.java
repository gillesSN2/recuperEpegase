package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.Modules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ModulesRepository extends JpaRepository<Modules, String>, JpaSpecificationExecutor<Modules> {

}