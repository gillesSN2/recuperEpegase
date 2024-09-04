package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.PayFeuilleCalcul;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PayFeuilleCalculRepository extends JpaRepository<PayFeuilleCalcul, Long>, JpaSpecificationExecutor<PayFeuilleCalcul> {

}