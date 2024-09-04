package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.PaySalariesPretsLignes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PaySalariesPretsLignesRepository extends JpaRepository<PaySalariesPretsLignes, Long>, JpaSpecificationExecutor<PaySalariesPretsLignes> {

}