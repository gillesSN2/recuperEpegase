package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.PaySalariesPrets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PaySalariesPretsRepository extends JpaRepository<PaySalariesPrets, Long>, JpaSpecificationExecutor<PaySalariesPrets> {

}