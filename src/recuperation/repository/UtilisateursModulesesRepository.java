package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.UtilisateursModuleses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UtilisateursModulesesRepository extends JpaRepository<UtilisateursModuleses, String>, JpaSpecificationExecutor<UtilisateursModuleses> {

}