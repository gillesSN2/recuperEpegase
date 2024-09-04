package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.PaySalariesContrats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PaySalariesContratsRepository extends JpaRepository<PaySalariesContrats, Long>, JpaSpecificationExecutor<PaySalariesContrats> {

}