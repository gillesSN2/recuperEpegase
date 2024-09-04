package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.PaySalariesConges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PaySalariesCongesRepository extends JpaRepository<PaySalariesConges, Long>, JpaSpecificationExecutor<PaySalariesConges> {

}