package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CptExercicesComptable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CptExercicesComptableRepository extends JpaRepository<CptExercicesComptable, Long>, JpaSpecificationExecutor<CptExercicesComptable> {

}