package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.McfExercicesMicrofinance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface McfExercicesMicrofinanceRepository extends JpaRepository<McfExercicesMicrofinance, Long>, JpaSpecificationExecutor<McfExercicesMicrofinance> {

}