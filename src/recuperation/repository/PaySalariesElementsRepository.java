package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.PaySalariesElements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PaySalariesElementsRepository extends JpaRepository<PaySalariesElements, Long>, JpaSpecificationExecutor<PaySalariesElements> {

}