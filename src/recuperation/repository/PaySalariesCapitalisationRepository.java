package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.PaySalariesCapitalisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PaySalariesCapitalisationRepository extends JpaRepository<PaySalariesCapitalisation, Long>, JpaSpecificationExecutor<PaySalariesCapitalisation> {

}