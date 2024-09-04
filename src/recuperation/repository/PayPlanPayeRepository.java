package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.PayPlanPaye;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PayPlanPayeRepository extends JpaRepository<PayPlanPaye, Long>, JpaSpecificationExecutor<PayPlanPaye> {

}