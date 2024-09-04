package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.PaySalaries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PaySalariesRepository extends JpaRepository<PaySalaries, Long>, JpaSpecificationExecutor<PaySalaries> {

}