package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.PayFeuilleCalculFormule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PayFeuilleCalculFormuleRepository extends JpaRepository<PayFeuilleCalculFormule, Long>, JpaSpecificationExecutor<PayFeuilleCalculFormule> {

}