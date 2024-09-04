package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.PaySalariesVariables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PaySalariesVariablesRepository extends JpaRepository<PaySalariesVariables, Long>, JpaSpecificationExecutor<PaySalariesVariables> {

}